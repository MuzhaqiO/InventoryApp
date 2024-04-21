package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.billDTO.BillCreateDTO;
import com.muzhaqi.InventoryApp.dto.billDTO.BillEntityResponseDTO;
import com.muzhaqi.InventoryApp.dto.billDTO.BillTransactionDTO;
import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionCreateDTO;
import com.muzhaqi.InventoryApp.entity.Bill;
import com.muzhaqi.InventoryApp.entity.Transaction;
import com.muzhaqi.InventoryApp.enums.Type;
import com.muzhaqi.InventoryApp.mapper.BillMapper;
import com.muzhaqi.InventoryApp.mapper.TransactionMapper;
import com.muzhaqi.InventoryApp.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillService {
    private final BillRepository billRepository;
    private final BillMapper billMapper;
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;
    private final WarehouseService warehouseService;

    public BillEntityResponseDTO getBillById (Long id){
        return billMapper.toDTO(billRepository.getReferenceById(id));
    }

    public List<BillEntityResponseDTO> getBills (){
        return billMapper.toDTOs(billRepository.findAll());
    }

    public BillEntityResponseDTO createBill (BillCreateDTO billCreateDTO){
        Bill bill = billMapper.toCreateEntity(billCreateDTO);
        bill.setDate(Date.valueOf(LocalDate.now()));
        bill.setType(Type.valueOf(billCreateDTO.getType()));
        bill.setTotalValue(billCreateDTO.getTransactions().stream().mapToDouble(billTransactionDTO -> {
            long transactionId = billTransactionDTO.getId();
            Transaction transaction = transactionMapper.toEntity(transactionService.getTransactionById(transactionId));
            return transaction.getFinalValue();
        }).sum());
        List<Long> transactionsIds = billCreateDTO.getTransactions().stream().map(BillTransactionDTO::getId).toList();
        List<TransactionCreateDTO> transactions = transactionService.getTransactionByIds(transactionsIds);

        Type billType = Type.valueOf(billCreateDTO.getType());
        updateWarehouseQuantities(transactions, billType);
        billRepository.save(bill);
        return billMapper.toDTO(bill);
    }

    private void updateWarehouseQuantities(List<TransactionCreateDTO> transactionCreateDTOs, Type billType){
        for (TransactionCreateDTO transactionCreateDTO : transactionCreateDTOs){
            warehouseService.updateProductQuantity(transactionCreateDTO, billType);
        }
    }
}

package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionCreateDTO;
import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Bill;
import com.muzhaqi.InventoryApp.entity.Product;
import com.muzhaqi.InventoryApp.entity.Transaction;
import com.muzhaqi.InventoryApp.entity.Warehouse;
import com.muzhaqi.InventoryApp.enums.Type;
import com.muzhaqi.InventoryApp.mapper.TransactionMapper;
import com.muzhaqi.InventoryApp.repository.BillRepository;
import com.muzhaqi.InventoryApp.repository.ProductRepository;
import com.muzhaqi.InventoryApp.repository.TransactionRepository;
import com.muzhaqi.InventoryApp.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final ProductRepository productRepository;
    private final BillRepository billRepository;
    private final WarehouseService warehouseService;

    public TransactionEntityResponseDTO getTransactionById (Long id){
        return transactionMapper.toDTO(transactionRepository.getReferenceById(id));
    }

    public List<TransactionCreateDTO> getTransactionByIds(List<Long> transactionIds){
        return transactionMapper.toCreateDTOs(transactionRepository.findByIdIn(transactionIds));
    }

    public TransactionEntityResponseDTO createTransaction (Long billId, TransactionCreateDTO transactionCreateDTO){
        Product product = productRepository.getReferenceById(transactionCreateDTO.getProductId());
        if (transactionCreateDTO.getFinalPrice() == null) {
            transactionCreateDTO.setFinalPrice(product.getPrice());
        }
        Transaction transaction = transactionMapper.toCreateEntity(transactionCreateDTO);
        Bill bill = billRepository.getReferenceById(billId);
        transaction.setBill(bill);
        Double finalPrice = transactionCreateDTO.getFinalPrice();
        transaction.setFinalValue(transactionCreateDTO.getQuantity()*finalPrice);
        Type billType = Type.valueOf(bill.getType().toString());
        warehouseService.updateProductQuantity(transactionCreateDTO, billType);
        Double newTotalValue = bill.getTransactions().stream()
                .mapToDouble(Transaction::getFinalValue)
                .sum() + transaction.getFinalValue();
        bill.setTotalValue(newTotalValue);
        transactionRepository.save(transaction);
        billRepository.save(bill);
        TransactionEntityResponseDTO responseDTO = transactionMapper.toDTO(transaction);
        responseDTO.setProductName(product.getName());
        responseDTO.setPrice(product.getPrice());

        return responseDTO;
    }
}

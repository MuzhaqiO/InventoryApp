package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionCreateDTO;
import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Product;
import com.muzhaqi.InventoryApp.entity.Transaction;
import com.muzhaqi.InventoryApp.entity.Warehouse;
import com.muzhaqi.InventoryApp.mapper.TransactionMapper;
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
    private final WarehouseRepository warehouseRepository;

    public TransactionEntityResponseDTO getTransactionById (Long id){
        return transactionMapper.toDTO(transactionRepository.getReferenceById(id));
    }

    public TransactionEntityResponseDTO createTransaction (TransactionCreateDTO transactionCreateDTO){
        Transaction transaction = transactionMapper.toCreateEntity(transactionCreateDTO);
        Product product = productRepository.getReferenceById(transactionCreateDTO.getProductId());
        transaction.setFinalValue(transactionCreateDTO.getQuantity()*product.getPrice());
        transactionRepository.save(transaction);
        return transactionMapper.toDTO(transaction);
    }
    public List<TransactionCreateDTO> getTransactionByIds(List<Long> transactionIds){
        return transactionMapper.toCreateDTOs(transactionRepository.findByIdIn(transactionIds));
    }
}

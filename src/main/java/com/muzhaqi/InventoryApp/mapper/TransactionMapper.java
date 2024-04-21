package com.muzhaqi.InventoryApp.mapper;

import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionCreateDTO;
import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "product.id", target = "productId")
    TransactionCreateDTO toCreateDTO (Transaction transaction);
    List<TransactionCreateDTO> toCreateDTOs (List<Transaction> transactions);
    @Mapping(source = "productId", target = "product.id")
    Transaction toCreateEntity (TransactionCreateDTO transactionCreateDTO);
    List<Transaction> toCreateEntities (List<TransactionCreateDTO> transactionCreateDTOs);

    @Mapping(source = "product.id", target = "productId")
    TransactionEntityResponseDTO toDTO (Transaction transaction);
    List<TransactionEntityResponseDTO> toDTOs (List<Transaction> transactions);
    @Mapping(source = "productId", target = "product.id")
    Transaction toEntity (TransactionEntityResponseDTO transactionEntityResponseDTO);
    List<Transaction> toEntities (List<TransactionEntityResponseDTO> transactionEntityResponseDTOs);
}

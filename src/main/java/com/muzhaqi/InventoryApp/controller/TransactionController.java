package com.muzhaqi.InventoryApp.controller;

import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionCreateDTO;
import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionEntityResponseDTO;
import com.muzhaqi.InventoryApp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "inventoryApp/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("transactionId/{id}")
    public ResponseEntity<TransactionEntityResponseDTO> getTransactionById(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }
    @PostMapping("createTransaction")
    public ResponseEntity<TransactionEntityResponseDTO> createTransaction(@RequestBody TransactionCreateDTO transactionCreateDTO){
        return ResponseEntity.ok(transactionService.createTransaction(transactionCreateDTO));
    }
}

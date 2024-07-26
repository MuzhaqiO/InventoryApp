package com.muzhaqi.InventoryApp.dto.transactionDTO;

import lombok.Data;

@Data
public class TransactionEntityResponseDTO {
    private Long id;
    private String productName;
    private Double price;
    private Double finalPrice;
    private Long quantity;
    private Long finalValue;
}

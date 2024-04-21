package com.muzhaqi.InventoryApp.dto.transactionDTO;

import lombok.Data;

@Data
public class TransactionEntityResponseDTO {
    private Long id;
    private Long productId;
    private Long quantity;
    private Long finalValue;
}

package com.muzhaqi.InventoryApp.dto.transactionDTO;

import lombok.Data;

@Data
public class TransactionCreateDTO {
    private Long productId;
    private Long quantity;
    private Double finalPrice;
}

package com.muzhaqi.InventoryApp.dto.warehouseDTO;

import lombok.Data;

@Data
public class WarehouseEntityResponseDTO {
    private Long productId;
    private String name;
    private Long quantity;
}

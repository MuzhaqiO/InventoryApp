package com.muzhaqi.InventoryApp.dto.productDTO;

import lombok.Data;

import java.util.List;

@Data
public class ProductEntityResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private List<ProductCategoryDTO> categories;
}

package com.muzhaqi.InventoryApp.dto.productDTO;

import lombok.Data;

import java.util.List;

@Data
public class ProductCreateDTO {
    private String name;
    private Double price;
    private List<ProductCategoryDTO> categories;
}

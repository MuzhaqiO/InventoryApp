package com.muzhaqi.InventoryApp.dto.productDTO;

import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryEntityResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductEntityResponseDTO {
    private Long id;
    private String name;
    private Double price;
}

package com.muzhaqi.InventoryApp.mapper;

import com.muzhaqi.InventoryApp.dto.productDTO.ProductCategoryDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductCreateDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductCreateDTO toCreateDTO (Product product);
    List<ProductCreateDTO> toCreateDTOs (List<Product> products);
    Product toCreateEntity (ProductCreateDTO productCreateDTO);
    List<Product> toCreateEntities (List<ProductCreateDTO> productCreateDTOs);

    ProductEntityResponseDTO toDTO (Product product);
    List<ProductEntityResponseDTO> toDTOs (List<Product> products);
    Product toEntity (ProductEntityResponseDTO productEntityResponseDTO);
    List<Product> toEntities (List<ProductEntityResponseDTO> productEntityResponseDTOs);

    ProductCategoryDTO toCategoryDTO (Product product);
    List<ProductCategoryDTO> toCategoryDTOs (List<Product> products);
    Product toCategoryEntity (ProductCategoryDTO productCategoryDTO);
    List<Product> toCategoryEntities (List<ProductCategoryDTO> productCategoryDTOs);

}

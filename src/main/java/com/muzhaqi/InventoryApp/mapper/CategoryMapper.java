package com.muzhaqi.InventoryApp.mapper;

import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryCreateDTO;
import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryCreateDTO toCreateDTO (Category category);
    List<CategoryCreateDTO> toCreateDTOs (List<Category> categories);
    Category toCreateEntity (CategoryCreateDTO categoryCreateDTO);
    List<Category> toCreateEntities (List<CategoryCreateDTO> categoryCreateDTOs);

    CategoryEntityResponseDTO toDTO (Category category);
    List<CategoryEntityResponseDTO> toDTOs (List<Category> categories);
    Category toEntity (CategoryEntityResponseDTO categoryEntityResponseDTO);
    List<Category> toEntities (List<CategoryEntityResponseDTO> categoryEntityResponseDTOs);
}

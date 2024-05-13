package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryCreateDTO;
import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Category;
import com.muzhaqi.InventoryApp.mapper.CategoryMapper;
import com.muzhaqi.InventoryApp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryEntityResponseDTO getCategoryById (Long id){
        return categoryMapper.toDTO(categoryRepository.getReferenceById(id));
    }
    public CategoryEntityResponseDTO getCategoryByName (String name){
        return categoryMapper.toDTO(categoryRepository.getCategoryByName(name));
    }
    public List<CategoryEntityResponseDTO> getAllCategories (){
        return categoryMapper.toDTOs(categoryRepository.findAll());
    }
    public CategoryEntityResponseDTO createCategory (CategoryCreateDTO categoryCreateDTO){
        Category createdCategory = categoryRepository.save(categoryMapper.toCreateEntity(categoryCreateDTO));
        return categoryMapper.toDTO(createdCategory);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
    public CategoryEntityResponseDTO updateCategory (Long id, CategoryCreateDTO categoryCreateDTO){
        Category category = categoryRepository.getReferenceById(id);
        category.setName(categoryCreateDTO.getName());
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(savedCategory);
    }
}

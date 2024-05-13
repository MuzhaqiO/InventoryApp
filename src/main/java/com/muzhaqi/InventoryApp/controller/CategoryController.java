package com.muzhaqi.InventoryApp.controller;

import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryCreateDTO;
import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryEntityResponseDTO;
import com.muzhaqi.InventoryApp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inventoryApp/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("categoryId/{id}")
    public ResponseEntity<CategoryEntityResponseDTO> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @GetMapping("categoryName/{name}")
    public ResponseEntity<CategoryEntityResponseDTO> getCategoryByName(@PathVariable String name){
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<CategoryEntityResponseDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @PostMapping("createCategory")
    public ResponseEntity<CategoryEntityResponseDTO> createCategory(@RequestBody CategoryCreateDTO categoryCreateDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryCreateDTO));
    }
    @PostMapping("update/{id}")
    public CategoryEntityResponseDTO updateCategory(@PathVariable Long id, @RequestBody CategoryCreateDTO categoryCreateDTO){
        return categoryService.updateCategory(id, categoryCreateDTO);
    }
    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}

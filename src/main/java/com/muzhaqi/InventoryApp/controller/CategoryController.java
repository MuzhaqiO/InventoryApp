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
}

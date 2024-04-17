package com.muzhaqi.InventoryApp.controller;

import com.muzhaqi.InventoryApp.dto.productDTO.ProductCreateDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductEntityResponseDTO;
import com.muzhaqi.InventoryApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inventoryApp/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("productId/{id}")
    public ResponseEntity<ProductEntityResponseDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PostMapping("createProduct")
    public ResponseEntity<ProductEntityResponseDTO> createProduct(@RequestBody ProductCreateDTO productCreateDTO){
        return ResponseEntity.ok(productService.createProduct(productCreateDTO));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<ProductEntityResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}

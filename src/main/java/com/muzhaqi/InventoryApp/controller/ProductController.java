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
    @GetMapping("productName/{name}")
    public ResponseEntity<ProductEntityResponseDTO> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }
    @GetMapping("getProductsByCategoryId/{id}")
    public ResponseEntity<List<ProductEntityResponseDTO>> getProductsByCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductsByCategoryId(id));
    }
    @GetMapping("getProductsByCategoryName/{name}")
    public ResponseEntity<List<ProductEntityResponseDTO>> getProductsByCategoryName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductsByCategoryName(name));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<ProductEntityResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping("createProduct")
    public ResponseEntity<ProductEntityResponseDTO> createProduct(@RequestBody ProductCreateDTO productCreateDTO){
        return ResponseEntity.ok(productService.createProduct(productCreateDTO));
    }
}

package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.productDTO.ProductCreateDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Category;
import com.muzhaqi.InventoryApp.entity.Product;
import com.muzhaqi.InventoryApp.entity.Warehouse;
import com.muzhaqi.InventoryApp.mapper.CategoryMapper;
import com.muzhaqi.InventoryApp.mapper.ProductMapper;
import com.muzhaqi.InventoryApp.mapper.WarehouseMapper;
import com.muzhaqi.InventoryApp.repository.ProductRepository;
import com.muzhaqi.InventoryApp.repository.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final WarehouseService warehouseService;
    private final WarehouseMapper warehouseMapper;

    public ProductEntityResponseDTO getProductById (Long id){
        return productMapper.toDTO(productRepository.getReferenceById(id));
    }
    public ProductEntityResponseDTO getProductByName (String name){
        return productMapper.toDTO(productRepository.getProductByName(name));
    }
    public List<ProductEntityResponseDTO> getAllProducts (){
        return productMapper.toDTOs(productRepository.findAll());
    }
    public ProductEntityResponseDTO createProduct (ProductCreateDTO productCreateDTO){
        Product product = productMapper.toCreateEntity(productCreateDTO);

        Warehouse warehouse =new Warehouse();
        warehouse.setProduct(product);
        warehouse.setName(productCreateDTO.getName());
        warehouse.setQuantity(0L);

        product.setWarehouse(warehouse);
        productRepository.save(product);

        return productMapper.toDTO(product);
    }
    public ProductEntityResponseDTO updateProduct(Long id, ProductCreateDTO productCreateDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        product.setName(productCreateDTO.getName());
        product.setPrice(productCreateDTO.getPrice());
        Warehouse warehouse = warehouseMapper.toEntity(warehouseService.getWarehouseById(id));
        warehouse.setName(productCreateDTO.getName());
        product.setWarehouse(warehouse);

        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

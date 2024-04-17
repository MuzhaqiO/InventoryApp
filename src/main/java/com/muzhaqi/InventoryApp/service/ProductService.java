package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.productDTO.ProductCreateDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Product;
import com.muzhaqi.InventoryApp.mapper.ProductMapper;
import com.muzhaqi.InventoryApp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductEntityResponseDTO getProductById (Long id){
        return productMapper.toDTO(productRepository.getReferenceById(id));
    }
    public ProductEntityResponseDTO createProduct (ProductCreateDTO productCreateDTO){
        Product createdProduct = productRepository.save(productMapper.toCreateEntity(productCreateDTO));
        return productMapper.toDTO(createdProduct);
    }
    public List<ProductEntityResponseDTO> getAllProducts (){
        return productMapper.toDTOs(productRepository.findAll());
    }
}

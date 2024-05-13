package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryCreateDTO;
import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryEntityResponseDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductCategoryDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductCreateDTO;
import com.muzhaqi.InventoryApp.dto.productDTO.ProductEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Category;
import com.muzhaqi.InventoryApp.entity.Product;
import com.muzhaqi.InventoryApp.entity.Warehouse;
import com.muzhaqi.InventoryApp.mapper.CategoryMapper;
import com.muzhaqi.InventoryApp.mapper.ProductMapper;
import com.muzhaqi.InventoryApp.repository.ProductRepository;
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
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public ProductEntityResponseDTO getProductById (Long id){
        return productMapper.toDTO(productRepository.getReferenceById(id));
    }
    public ProductEntityResponseDTO getProductByName (String name){
        return productMapper.toDTO(productRepository.getProductByName(name));
    }
    public List<ProductEntityResponseDTO> getProductsByCategoryId (Long id){
        return productMapper.toDTOs(productRepository.getProductByCategoriesId(id));
    }
    public List<ProductEntityResponseDTO> getProductsByCategoryName (String name){
        return productMapper.toDTOs(productRepository.getProductByCategoriesName(name));
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

        List<ProductCategoryDTO> productCategoryDTOList = productCreateDTO.getCategories();
        List<Category> categories = new ArrayList<>();

        for (ProductCategoryDTO productCategoryDTO : productCategoryDTOList) {
            Category category = categoryMapper.toEntity(categoryService.getCategoryById(productCategoryDTO.getId()));
            categories.add(category);
        }

        product.setCategories(categories);

        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

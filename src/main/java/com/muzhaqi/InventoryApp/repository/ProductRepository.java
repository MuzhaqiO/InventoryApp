package com.muzhaqi.InventoryApp.repository;

import com.muzhaqi.InventoryApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductByName (String name);
    List<Product> getProductByCategoriesId (Long id);
    List<Product> getProductByCategoriesName (String name);
}

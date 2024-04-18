package com.muzhaqi.InventoryApp.repository;

import com.muzhaqi.InventoryApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getCategoryByName (String name);
}

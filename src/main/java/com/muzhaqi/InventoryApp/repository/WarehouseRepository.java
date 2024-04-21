package com.muzhaqi.InventoryApp.repository;

import com.muzhaqi.InventoryApp.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

//    @Query("SELECT warehouse.quantity * products.price AS worth FROM warehouse JOIN products ON warehouse.productId = products.id")
//    Double getWorth();
}

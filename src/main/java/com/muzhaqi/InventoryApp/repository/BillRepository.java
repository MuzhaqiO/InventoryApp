package com.muzhaqi.InventoryApp.repository;

import com.muzhaqi.InventoryApp.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}

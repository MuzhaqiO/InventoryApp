package com.muzhaqi.InventoryApp.repository;

import com.muzhaqi.InventoryApp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByIdIn(List<Long> ids);
}

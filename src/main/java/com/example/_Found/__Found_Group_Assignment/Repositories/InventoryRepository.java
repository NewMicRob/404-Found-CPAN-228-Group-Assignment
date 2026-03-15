package com.example._Found.__Found_Group_Assignment.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example._Found.__Found_Group_Assignment.Models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProductId(Integer productId);

    List<Inventory> findByQuantityLessThan(Integer threshold);

    List<Inventory> findByWarehouseId(Integer warehouseId);

    Page<Inventory> findByProductNameContainingIgnoreCase(String name, Pageable pageable);

}
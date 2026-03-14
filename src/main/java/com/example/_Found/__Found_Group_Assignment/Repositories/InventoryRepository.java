package com.example._Found.__Found_Group_Assignment.Repositories;

import com.example._Found.__Found_Group_Assignment.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProductId(Integer productId);

    List<Inventory> findByQuantityLessThan(Integer threshold);

    List<Inventory> findByWarehouseId(Integer warehouseId);
}
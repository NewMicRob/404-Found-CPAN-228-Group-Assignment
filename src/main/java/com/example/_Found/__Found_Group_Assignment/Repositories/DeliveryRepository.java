package com.example._Found.__Found_Group_Assignment.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example._Found.__Found_Group_Assignment.Models.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByStatusIgnoreCase(String status);
    List<Delivery> findByWarehouseId(int warehouseId);
}

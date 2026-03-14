package com.example._Found.__Found_Group_Assignment.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example._Found.__Found_Group_Assignment.Models.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByProductId(int productId);
    List<Shipment> findByWarehouse_Id(int warehouseId);
}
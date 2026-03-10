package com.example._Found.__Found_Group_Assignment.Repositories;

import com.example._Found.__Found_Group_Assignment.Models.ProductSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductSupplyRepository extends JpaRepository<ProductSupply, Long> {
    List<ProductSupply> findByStatusIgnoreCase(String status);
    List<ProductSupply> findBySuppliedBy(String suppliedBy);
    List<ProductSupply> findByProductId(Long productId);
    List<ProductSupply> findByWarehouseId(Long warehouseId);
}

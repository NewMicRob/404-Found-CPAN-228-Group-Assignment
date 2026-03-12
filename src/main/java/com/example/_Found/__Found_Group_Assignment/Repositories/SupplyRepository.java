package com.example._Found.__Found_Group_Assignment.Repositories;

import com.example._Found.__Found_Group_Assignment.Models.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    List<Supply> findByStatusIgnoreCase(String status);
    List<Supply> findBySuppliedBy(String suppliedBy);
    List<Supply> findByProductId(Long productId);
    List<Supply> findByWarehouseId(Long warehouseId);
}

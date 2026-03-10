package com.example._Found.__Found_Group_Assignment.Repositories;

import com.example._Found.__Found_Group_Assignment.Models.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductSaleRepository extends JpaRepository<ProductSale, Long> {
    List<ProductSale> findByProductId(Long productId);
    List<ProductSale> findBySaleDateBetween(LocalDateTime start, LocalDateTime end);
    List<ProductSale> findBySalePriceGreaterThan(Double price);
    List<ProductSale> findByQuantitySoldGreaterThan(Integer quantity);
    List<ProductSale> findByProductIdAndSaleDateAfter(Long productId, LocalDateTime date);
    List<ProductSale> findBySalePriceBetween(Double minPrice, Double maxPrice);
    List<ProductSale> findFirst10ByOrderBySaleDateDesc();
    List<ProductSale> findByWarehouseId(Long warehouseId);
}
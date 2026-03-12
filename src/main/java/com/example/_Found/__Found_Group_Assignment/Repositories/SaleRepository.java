package com.example._Found.__Found_Group_Assignment.Repositories;

import com.example._Found.__Found_Group_Assignment.Models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByProductId(Long productId);
    List<Sale> findBySaleDateBetween(LocalDateTime start, LocalDateTime end);
    List<Sale> findBySalePriceGreaterThan(Double price);
    List<Sale> findByQuantitySoldGreaterThan(Integer quantity);
    List<Sale> findByProductIdAndSaleDateAfter(Long productId, LocalDateTime date);
    List<Sale> findBySalePriceBetween(Double minPrice, Double maxPrice);
    List<Sale> findFirst10ByOrderBySaleDateDesc();
    //List<ProductSale> findByWarehouse_Id(Long id);
}
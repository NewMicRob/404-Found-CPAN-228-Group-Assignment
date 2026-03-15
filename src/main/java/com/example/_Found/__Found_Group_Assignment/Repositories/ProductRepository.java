package com.example._Found.__Found_Group_Assignment.Repositories;
import com.example._Found.__Found_Group_Assignment.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Find all products in a specific category
    List<Product> findByCategoryId(Integer categoryId);

    List<Product> findByDeletedFalse();

    // Derived query method
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable page);

    // Derived query method
    Page<Product> findByCategoryId(int categoryId, Pageable page);
}
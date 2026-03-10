package com.example._Found.__Found_Group_Assignment.Repositories;
import com.example._Found.__Found_Group_Assignment.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Find all products in a specific category
    List<Product> findByCategoryId(Integer categoryId);

}
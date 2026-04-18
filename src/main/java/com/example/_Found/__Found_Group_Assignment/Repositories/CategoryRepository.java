package com.example._Found.__Found_Group_Assignment.Repositories;
import com.example._Found.__Found_Group_Assignment.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // Find all top-level categories (no parent)
    List<Category> findByParentIsNull();

    // Find all subcategories (have parents)
    List<Category> findByParentIsNotNull();
}
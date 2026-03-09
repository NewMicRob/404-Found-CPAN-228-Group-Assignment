package com.example._Found.__Found_Group_Assignment.Repository;
import com.example._Found.__Found_Group_Assignment.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // Find all top-level categories (no parent)
    List<Category> findByParentIsNull();

    // Find all children of a specific category
    List<Category> findByParentId(Integer parentId);
}
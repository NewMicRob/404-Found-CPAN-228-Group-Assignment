package com.example._Found.__Found_Group_Assignment.Service;

import com.example._Found.__Found_Group_Assignment.Model.Category;
import com.example._Found.__Found_Group_Assignment.Repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get a category by ID
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    // Save or update a category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Delete a category by ID
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    // Get direct children of a category by ID
    public List<Category> getChildren(int parentId) {
        return categoryRepository.findByParentId(parentId);
    }

}
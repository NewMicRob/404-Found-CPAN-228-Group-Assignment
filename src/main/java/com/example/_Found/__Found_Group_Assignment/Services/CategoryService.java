package com.example._Found.__Found_Group_Assignment.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example._Found.__Found_Group_Assignment.Models.Category;
import com.example._Found.__Found_Group_Assignment.Repositories.CategoryRepository;

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
    public Category getCategoryById(Integer id) { return categoryRepository.findById(id).orElse(null); }

    // Save or update a category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getSubCategories() {
        return categoryRepository.findByParentIsNotNull();
    }

    public List<Category> getParentCategories(){
        return categoryRepository.findByParentIsNull();
    }

}
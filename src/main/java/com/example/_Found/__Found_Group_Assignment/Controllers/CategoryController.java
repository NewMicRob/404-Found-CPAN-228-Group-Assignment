package com.example._Found.__Found_Group_Assignment.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example._Found.__Found_Group_Assignment.Models.Category;
import com.example._Found.__Found_Group_Assignment.Services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Show all the categories
    @GetMapping
    public String showAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("category", new Category());
        return "categories";
    }

    // Show the create category form
//    @GetMapping("/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("category", new Category());
//        model.addAttribute("categories", categoryService.getAllCategories()); // for parent selection
//        return "createCategory";
//    }

    // Handle form submission
    @PostMapping
    public String saveCategory(@ModelAttribute Category category,
                               @RequestParam(required = false) Integer parentId) {
        if (parentId != null) {
            Category parentCategory = categoryService.getCategoryById(parentId).orElse(null);
            category.setParent(parentCategory);
        }
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
}

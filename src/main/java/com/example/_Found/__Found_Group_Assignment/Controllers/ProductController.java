package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Category;
import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Services.CategoryService;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController (ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // Show all the products
    @GetMapping
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("parentCategories", categoryService.getParentCategories());
        model.addAttribute("category", new Category());
        return "products";
    }

//    // Show the create product form
//    @GetMapping("/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("product", new Product());
//        var categories = categoryService.getAllCategories();
//        System.out.println("Categories loaded: " + categories.size());
//        categories.forEach(c -> System.out.println("  - " + c.getId() + ": " + c.getName()));
//        model.addAttribute("categories", categories);
//        return "createProduct";
//    }

    // Handle createProduct form submission
    @PostMapping
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Handle createCategory form submission
    @PostMapping("/category")
    public String saveCategory(@ModelAttribute Category category,
                               @RequestParam(required = false) Integer parentId) {
        if (parentId != null) {
            Category parentCategory = categoryService.getCategoryById(parentId).orElse(null);
            category.setParent(parentCategory);
        }
        categoryService.saveCategory(category);
        return "redirect:/products";
    }
}
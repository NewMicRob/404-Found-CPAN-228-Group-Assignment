package com.example._Found.__Found_Group_Assignment.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example._Found.__Found_Group_Assignment.Models.Category;
import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Services.CategoryService;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController (ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // Show all the products *Updated for search
    @GetMapping
    public String showAllProducts(
        @RequestParam(required = false) String search,
        Model model) {
        
        List<Product> allProducts = productService.getAllProducts();

        if (search != null && !search.isEmpty()) {
            List<Product> filteredProducts = new ArrayList<>();
            for (Product product : allProducts) {
                if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                    filteredProducts.add(product);
                }
            }
            model.addAttribute("products", filteredProducts);
        } else {
            model.addAttribute("products", allProducts);
        }

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("parentCategories", categoryService.getParentCategories());
        model.addAttribute("category", new Category());
        return "products";
    }

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
        return "redirect:/categories";
    }
}
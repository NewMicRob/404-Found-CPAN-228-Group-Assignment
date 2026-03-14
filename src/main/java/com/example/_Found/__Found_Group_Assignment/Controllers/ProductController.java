package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Category;
import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Services.CategoryService;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        // If parent category is selected
        if (parentId != null) {
            Category parent = categoryService.getCategoryById(parentId);
            category.setParent(parent);
        } else {
            category.setParent(null); // No parent selected
        }
        categoryService.saveCategory(category);
        return "redirect:/products";
    }

    // Handle product deletion (mark as deleted)
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        Optional<Product> optionalProduct = productService.getProductById(id); // Optional<Product>

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setDeleted(true);            // mark as deleted
            productService.saveProduct(product);
        }
        return "redirect:/products";
    }
}
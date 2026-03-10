package com.example._Found.__Found_Group_Assignment.Controller;

import com.example._Found.__Found_Group_Assignment.Model.Product;
import com.example._Found.__Found_Group_Assignment.Service.CategoryService;
import com.example._Found.__Found_Group_Assignment.Service.ProductService;
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
        return "products";
    }

    // Show the create product form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        var categories = categoryService.getAllCategories();
        System.out.println("Categories loaded: " + categories.size());
        categories.forEach(c -> System.out.println("  - " + c.getId() + ": " + c.getName()));
        model.addAttribute("categories", categories);
        return "createProduct";
    }

    // Handle form submission
    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/create";
    }
}
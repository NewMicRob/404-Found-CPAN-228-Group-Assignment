package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example._Found.__Found_Group_Assignment.Services.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public AdminController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // Show page with optional name filter
    @GetMapping
    public String adminProducts(
            @RequestParam(name = "search", defaultValue = "") String search,
            @RequestParam(name = "page", defaultValue = "0") int  page,
            Model model) {

        Pageable pageable = PageRequest.of(page, 5);

        Page<Product> productPage;

        if (!search.isEmpty()) {
                productPage = productService.findByName(search, pageable);
        } else {
            productPage = productService.getAllProductsPageable(pageable);
        }

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("search", search);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("selectedProduct", productPage.hasContent() ? productPage.getContent().get(0) : null);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("total", productPage.getTotalElements());
        model.addAttribute("hasPrevious", productPage.hasPrevious());
        model.addAttribute("hasNext", productPage.hasNext());
        model.addAttribute("pageSize", 5);

        int startIndex = page * 5 + 1;
        int endIndex = Math.min((page + 1) * 5, (int) productPage.getTotalElements());

        model.addAttribute("startIndex", startIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin";
    }

    // Delete
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        Product product = productService.getProductById(id);
        product.setDeleted(true);
        productService.saveProduct(product);

        return "redirect:/admin";
    }

    // Update
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin";
    }
}
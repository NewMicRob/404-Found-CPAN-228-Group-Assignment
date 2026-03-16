package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Category;
import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Services.CategoryService;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

//    // Show all the products
//    @GetMapping
//    public String showAllProducts(Model model) {
//        model.addAttribute("products", productService.getAllProducts());
//        model.addAttribute("product", new Product());
//        model.addAttribute("categories", categoryService.getAllCategories());
//        model.addAttribute("parentCategories", categoryService.getParentCategories());
//        model.addAttribute("category", new Category());
//        return "products";
//    }

    @GetMapping
    public String showAllProducts(
            @RequestParam(name = "filterType", defaultValue = "all") String filterType,
            @RequestParam(name = "search", defaultValue = "") String search,
            @RequestParam(name = "categoryId", defaultValue = "0", required = false) int categoryId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sort", defaultValue = "id") String sortBy,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            Model model) {

        Sort.Direction sortDirection = direction.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        Page<Product> productPage;

        // Apply filters together
        switch (filterType) {
            case "name":
                productPage = productService.findByName(search, pageable);
                break;

            case "category":
                productPage = categoryId != 0
                        ? productService.findByCategory(categoryId, pageable)
                        : productService.getAllProductsPageable(pageable);
                break;

            default:
                productPage = productService.getAllProductsPageable(pageable);
        }

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("total", productPage.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("filterType", filterType);
        model.addAttribute("search", search);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("sort", sortBy);
        model.addAttribute("direction", direction);
        model.addAttribute("hasPrevious", productPage.hasPrevious());
        model.addAttribute("hasNext", productPage.hasNext());

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("parentCategories", categoryService.getParentCategories());
        model.addAttribute("category", new Category());

        return "products";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable int id) {
        Product p = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return p;
    }

    // Handle createProduct form submission
    @PostMapping
    public String saveProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult,
            Model model) {

        // Check for validation errors
        if (bindingResult.hasErrors()) {
              model.addAttribute("categories", categoryService.getParentCategories());
              return "fragments/createProduct_modal :: createProduct_modal";
        }
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

//    @GetMapping("/update/{id}")
//    public String showUpdateProduct(@PathVariable int id, Model model) {
//        Product product = productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
//        model.addAttribute("product", product);
//        model.addAttribute("parentCategories", categoryService.getParentCategories());
//        return "Fragments/updateProduct_modal :: updateProduct_modal";
//    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("parentCategories", categoryService.getParentCategories());
            return "redirect:/products";
        }

        productService.saveProduct(product);

        return "redirect:/products";
    }

}
package com.example._Found.__Found_Group_Assignment.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example._Found.__Found_Group_Assignment.Models.Category;
import com.example._Found.__Found_Group_Assignment.Models.Inventory;
import com.example._Found.__Found_Group_Assignment.Models.Product;
import com.example._Found.__Found_Group_Assignment.Models.Warehouse;
import com.example._Found.__Found_Group_Assignment.Repositories.InventoryRepository;
import com.example._Found.__Found_Group_Assignment.Services.CategoryService;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import com.example._Found.__Found_Group_Assignment.Services.WarehouseService;

@Controller
public class HomeController {

    private final InventoryRepository inventoryRepository;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final WarehouseService warehouseService;

    // Inject the repository via constructor
    // Added the services for the quickref add/create section of the homepage
    public HomeController(InventoryRepository inventoryRepository, ProductService productService, CategoryService categoryService, WarehouseService warehouseService) {
        this.inventoryRepository = inventoryRepository;
        this.productService = productService;
        this.categoryService = categoryService;
        this.warehouseService = warehouseService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Inventory> inventoryList = inventoryRepository.findAll();

        Map<String, Integer> totals = new HashMap<>();
        for (Inventory i : inventoryList) {
            totals.put(
                    i.getProduct().getName(),
                    totals.getOrDefault(i.getProduct().getName(), 0) + i.getQuantity()
            );
        }

        // Separate keys and values for the chart
        List<String> labels = new ArrayList<>(totals.keySet());
        List<Integer> quantities = labels.stream()
                .map(totals::get)
                .collect(Collectors.toList());

        model.addAttribute("labels", labels);
        model.addAttribute("quantities", quantities);

        // Added attributes for the quickref add/create section of the homepage
        model.addAttribute("product", new Product());
        model.addAttribute("category", new Category());
        model.addAttribute("warehouse", new Warehouse());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        model.addAttribute("warehouseList", warehouseService.getAllWarehouses());
        model.addAttribute("parentCategories", categoryService.getParentCategories());
        model.addAttribute("productList", productService.getAllProducts());

        return "home"; // Thymeleaf template: home.html
    }
}


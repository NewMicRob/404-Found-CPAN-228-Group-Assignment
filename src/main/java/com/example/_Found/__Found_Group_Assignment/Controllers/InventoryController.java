package com.example._Found.__Found_Group_Assignment.Controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example._Found.__Found_Group_Assignment.Models.Inventory;
import com.example._Found.__Found_Group_Assignment.Services.InventoryService;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import com.example._Found.__Found_Group_Assignment.Services.WarehouseService;

@Controller
@RequestMapping ("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;


    @GetMapping
    public String viewInventory(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "sort", required = false, defaultValue = "product.name") String sortBy,
            @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            Model model) {

        Sort.Direction sortedDirection = direction.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(sortedDirection, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Inventory> inventoryPage;

        // Search logic
        if (search != null && !search.isEmpty()) {
            inventoryPage = inventoryService.findByProductName(search, pageable);
        } else {
            inventoryPage = inventoryService.getAllInventory(pageable);
        }

        model.addAttribute("inventoryList", inventoryPage.getContent());
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("warehouseList", warehouseService.getAllWarehouses());
        model.addAttribute("search", search);
        model.addAttribute("sort", sortBy);
        model.addAttribute("direction", direction);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", inventoryPage.getTotalPages());
        model.addAttribute("totalItems", inventoryPage.getTotalElements());
        model.addAttribute("size", size);
        model.addAttribute("hasPrevious", inventoryPage.hasPrevious());
        model.addAttribute("hasNext", inventoryPage.hasNext());
        model.addAttribute("startIndex", page * size + 1);
        model.addAttribute("endIndex", Math.min((page + 1) * size, (int) inventoryPage.getTotalElements()));
    
        return "inventory";
    }

    @PostMapping("/update")
    public String updateStock(
            @RequestParam int productId,
            @RequestParam int warehouseId,
            @RequestParam Integer amount,
            Model model) {

        try {
            inventoryService.updateStock(productId, warehouseId,  amount);
            return "redirect:/inventory";

        } catch (RuntimeException e) {
            model.addAttribute("errMessage", e.getMessage());
model.addAttribute("inventoryList", 
            inventoryService.getAllInventory(PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "product.name"))).getContent());
            model.addAttribute("productList", productService.getAllProducts());
            model.addAttribute("warehouseList", warehouseService.getAllWarehouses());
            model.addAttribute("search", "");
            model.addAttribute("sort", "product.name");
            model.addAttribute("direction", "ASC");
            model.addAttribute("currentPage", 0);
            model.addAttribute("totalPages", 1);
            model.addAttribute("size", 10);
            model.addAttribute("hasPrevious", false);
            model.addAttribute("hasNext", false);
            model.addAttribute("startIndex", 1);
            model.addAttribute("endIndex", 1);

            return "inventory";
        }
    }
}
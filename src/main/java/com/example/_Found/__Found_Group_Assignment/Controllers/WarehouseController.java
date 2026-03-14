package com.example._Found.__Found_Group_Assignment.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example._Found.__Found_Group_Assignment.Models.Warehouse;
import com.example._Found.__Found_Group_Assignment.Services.WarehouseService;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    // Show all the warehouses
    @GetMapping
    public String showAllWarehouses(Model model) {
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        model.addAttribute("warehouse", new Warehouse());
        return "warehouses";
    }

    // Show create warehouse form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        return "warehouses";
    }

    // Handle form submission
    @PostMapping("/create")
    public String saveWarehouse(@ModelAttribute Warehouse warehouse) {
        warehouseService.saveWarehouse(warehouse);
        return "redirect:/warehouses";
    }
}

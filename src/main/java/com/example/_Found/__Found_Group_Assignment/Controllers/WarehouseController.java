package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Warehouse;
import com.example._Found.__Found_Group_Assignment.Services.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "warehouses";
    }

    // Show create warehouse form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "createWarehouse";
    }

    // Handle form submission
    @PostMapping("/create")
    public String saveWarehouse(@ModelAttribute Warehouse warehouse) {
        warehouseService.saveWarehouse(warehouse);
        return "redirect:/warehouses/create";
    }
}

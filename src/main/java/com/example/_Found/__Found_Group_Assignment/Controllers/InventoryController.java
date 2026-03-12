package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Inventory;
import com.example._Found.__Found_Group_Assignment.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public String viewInventory(
            @RequestParam(required = false) String search,
            Model model) {

        List<Inventory> allList = inventoryService.getAllInventory();

        // Search logic
        if (search != null && !search.isEmpty()) {
            List<Inventory> filteredList = new ArrayList<>();

            for (Inventory item : allList) {
                // checks if name in search contains string
                if (item.getProduct().getName().toLowerCase().contains(search.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            // Sends matching items to table
            model.addAttribute("inventoryList", filteredList);
        } else {
            // Loads all
            model.addAttribute("inventoryList", allList);
        }
        return "Inventory";
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
            model.addAttribute("inventoryList", inventoryService.getAllInventory());

            return "Inventory";
        }
    }
}
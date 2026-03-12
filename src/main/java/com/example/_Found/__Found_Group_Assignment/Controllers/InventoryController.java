package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public String viewInventory(Model model) {
        model.addAttribute("inventoryList", inventoryService.getAllInventory());

        return "Inventory";
    }

    @PostMapping("/update")
    public String updateStock(
            @RequestParam Long productId,
            @RequestParam Integer amount,
    Model model) {

        try {
            inventoryService.updateStock(productId, amount);
            return "redirect:/inventory";

        } catch (RuntimeException e) {
            model.addAttribute("errMessage", e.getMessage());
            model.addAttribute("inventoryList", inventoryService.getAllInventory());

            return "Inventory";
        }
    }
}
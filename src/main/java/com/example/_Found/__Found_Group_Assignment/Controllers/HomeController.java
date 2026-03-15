package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Inventory;
import com.example._Found.__Found_Group_Assignment.Repositories.InventoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final InventoryRepository inventoryRepository;

    // Inject the repository via constructor
    public HomeController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
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

        return "home"; // Thymeleaf template: home.html
    }
}


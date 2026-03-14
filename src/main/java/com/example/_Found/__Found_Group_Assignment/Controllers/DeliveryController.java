package com.example._Found.__Found_Group_Assignment.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example._Found.__Found_Group_Assignment.Models.Delivery;
import com.example._Found.__Found_Group_Assignment.Services.DeliveryService;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import com.example._Found.__Found_Group_Assignment.Services.WarehouseService;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String showDeliveries(
    @RequestParam(required = false) String search,    
    Model model) {

        List<Delivery> allDeliveries = deliveryService.getAllDeliveries();

        if (search != null && !search.isEmpty()) {
        List<Delivery> filteredDeliveries = new ArrayList<>();
        for (Delivery delivery : allDeliveries) {
            if (delivery.getProduct().getName().toLowerCase().contains(search.toLowerCase()) ||
                (delivery.getDeliveredBy() != null && delivery.getDeliveredBy().toLowerCase().contains(search.toLowerCase()))) {
                filteredDeliveries.add(delivery);
            }
        }
        model.addAttribute("deliveryList", filteredDeliveries);
    } else {
        model.addAttribute("deliveryList", allDeliveries);
    }

        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("warehouseList", warehouseService.getAllWarehouses());

        return "deliveries";
    }

    // sends information to service to be saved
    @PostMapping("/addDelivery")
    public String addDelivery(@ModelAttribute Delivery delivery) { // converts form details into object
        deliveryService.saveDelivery(delivery);

        return "redirect:/deliveries";
    }
}

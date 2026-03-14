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

import com.example._Found.__Found_Group_Assignment.Models.Shipment;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import com.example._Found.__Found_Group_Assignment.Services.ShipmentService;
import com.example._Found.__Found_Group_Assignment.Services.WarehouseService;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String showShipment(
    @RequestParam(required = false) String search,    
    Model model) {

        List<Shipment> allShipments = shipmentService.getAllShipments();
        if (search != null && !search.isEmpty()) {
            List<Shipment> filteredShipments = new ArrayList<>();
            for (Shipment shipment : allShipments) {
                if (shipment.getProduct().getName().toLowerCase().contains(search.toLowerCase())) {
                    filteredShipments.add(shipment);
                }
            }
            model.addAttribute("shipmentsList", filteredShipments);
        } else {
            model.addAttribute("shipmentsList", allShipments);
        }
        
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("warehouseList", warehouseService.getAllWarehouses());
        
        return "shipments";
    }

    @PostMapping("/create")
    public String processShipment(@ModelAttribute Shipment shipment, Model model) {
        try {
            shipmentService.createShipment(shipment);
            return "redirect:/shipments";
        } catch (RuntimeException e) {
            model.addAttribute("errMessage", e.getMessage());
            model.addAttribute("shipmentsList", shipmentService.getAllShipments());
            model.addAttribute("productList", productService.getAllProducts());
            model.addAttribute("warehouseList", warehouseService.getAllWarehouses());

            return "shipments";
        }
    }
}
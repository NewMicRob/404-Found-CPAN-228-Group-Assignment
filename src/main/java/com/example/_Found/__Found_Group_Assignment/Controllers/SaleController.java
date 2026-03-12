package com.example._Found.__Found_Group_Assignment.Controllers;

import com.example._Found.__Found_Group_Assignment.Models.Sale;
import com.example._Found.__Found_Group_Assignment.Services.ProductService;
import com.example._Found.__Found_Group_Assignment.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showSale(Model model) {
        model.addAttribute("salesList", saleService.getAllSales());
        model.addAttribute("productList", productService.getAllProducts());
        return "Sale";
    }

    @PostMapping("/create")
    public String processSale(@ModelAttribute Sale sale, Model model) {
        try {
            saleService.createSale(sale);
            return "redirect:/sale";
        } catch (RuntimeException e) {
            model.addAttribute("errMessage", e.getMessage());
            model.addAttribute("salesList", saleService.getAllSales());
            model.addAttribute("productList", productService.getAllProducts());
            return "Sales";
        }
    }
}
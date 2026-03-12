package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.Sale;
import com.example._Found.__Found_Group_Assignment.Repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository productSaleRepository;

    @Autowired
    private InventoryService inventoryService;

    public List<Sale> getAllSales() {
        return productSaleRepository.findAll();
    }

    @Transactional
    public Sale createSale(Sale sale) {
        int productId = sale.getProduct().getId();
        int saleUpdate = sale.getQuantitySold() * - 1;

        inventoryService.updateStock((long)productId, saleUpdate);
        if (sale.getSaleDate() == null) {
            sale.setSaleDate(LocalDateTime.now());
        }
        return productSaleRepository.save(sale);
    }
}

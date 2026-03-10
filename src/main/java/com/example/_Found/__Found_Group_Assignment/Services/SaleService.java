package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.ProductSale;
import com.example._Found.__Found_Group_Assignment.Repositories.InventoryRepository;
import com.example._Found.__Found_Group_Assignment.Repositories.ProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private ProductSaleRepository productSaleRepository;

    @Autowired
    private InventoryService inventoryService;

    public List<ProductSale> getAllSales() {
        return productSaleRepository.findAll();
    }

    @Transactional
    public ProductSale createSale(ProductSale sale) {
        inventoryService.updateStock(sale.getProductId(), sale.getQuantitySold() * -1);

        return productSaleRepository.save(sale);
    }
}

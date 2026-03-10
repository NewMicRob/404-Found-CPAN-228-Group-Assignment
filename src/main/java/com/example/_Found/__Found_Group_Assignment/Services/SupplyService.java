package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.ProductSupply;
import com.example._Found.__Found_Group_Assignment.Repositories.ProductSupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SupplyService {
    @Autowired
    private ProductSupplyRepository productSupplyRepository;

    @Autowired
    private InventoryService inventoryService;

    public List<ProductSupply> getAllSupplies() {
        return productSupplyRepository.findAll();
    }

    @Transactional
    public ProductSupply totalSupply(Long supplyId) {
        ProductSupply supply = productSupplyRepository.findById(supplyId).orElseThrow(() -> new RuntimeException("No Supplies Found"));

        if (!"RECEIVED".equalsIgnoreCase(supply.getStatus())) {
            inventoryService.updateStock(supply.getProductId(), supply.getQuantityReceived());
            supply.setStatus("RECEIVED");
        }
        return productSupplyRepository.save(supply);
    }
}

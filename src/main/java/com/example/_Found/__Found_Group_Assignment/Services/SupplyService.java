package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.Supply;
import com.example._Found.__Found_Group_Assignment.Repositories.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SupplyService {
    @Autowired
    private SupplyRepository productSupplyRepository;

    @Autowired
    private InventoryService inventoryService;

    public List<Supply> getAllSupplies() {
        return productSupplyRepository.findAll();
    }

    @Transactional
    public Supply totalSupply(Long supplyId) {
        Supply supply = productSupplyRepository.findById(supplyId).orElseThrow(() -> new RuntimeException("No Supplies Found"));

        if (!"RECEIVED".equalsIgnoreCase(supply.getStatus())) {
            //inventoryService.updateStock(supply.getProductId(), supply.getQuantityReceived());
            supply.setStatus("RECEIVED");
        }
        return productSupplyRepository.save(supply);
    }
}

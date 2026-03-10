package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.Inventory;
import com.example._Found.__Found_Group_Assignment.Repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Transactional
    public Inventory updateStock(Long productId, Integer quantityChange) {
        List<Inventory> inventoryList = inventoryRepository.findByProductId(productId);

        Inventory inventory;

        if (inventoryList.isEmpty()) {
            if (quantityChange < 0) {
                throw new RuntimeException("Stock is not in Inventory");
            }
            inventory = new Inventory();
            inventory.setProduct(inventoryRepository.findById(productId).get());
            inventory.setQuantity(quantityChange);
        } else {
            inventory = inventoryList.get(0);
            int newTotal = inventory.getQuantity() + quantityChange;

            if (newTotal < 0) {
                throw new RuntimeException("Insufficient Stock");
            }
            inventory.setQuantity(newTotal);
        }
        return inventoryRepository.save(inventory);
    }
}

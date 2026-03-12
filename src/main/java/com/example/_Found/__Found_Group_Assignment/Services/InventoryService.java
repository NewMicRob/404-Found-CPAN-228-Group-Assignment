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

    // Changes stock levels deliveries and shipments
    @Transactional
    public Inventory updateStock(int productId, int warehouseId, Integer quantityChange) {
        // gets list of all items in inventory
        List<Inventory> inventoryList = inventoryRepository.findByProductId((long) productId);

        Inventory inventoryItem = null;

        // Goes through the items information to match warehouse
        for (Inventory item : inventoryList) {
            if (item.getWarehouse().getId() == warehouseId) {
                inventoryItem = item;
                break;
            }
        }

        // If item doesnt exist
        if (inventoryItem == null) {
            if (quantityChange < 0) {
                throw new RuntimeException("Item is not in stock");
            }
            // creates a new product
            inventoryItem = new Inventory();
            inventoryItem.setQuantity(quantityChange);

        } else {
            int newAmount = inventoryItem.getQuantity() + quantityChange;

            // Makes it so inventory doesnt drop below 0
            if (newAmount < 0) {
                throw new RuntimeException("Not enough available at this warehouse");
            }
            inventoryItem.setQuantity(newAmount);
        }
        // Saves new item or updates
        return inventoryRepository.save(inventoryItem);
    }
}

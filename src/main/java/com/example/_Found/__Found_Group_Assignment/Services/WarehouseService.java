package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.Warehouse;
import com.example._Found.__Found_Group_Assignment.Repositories.WarehouseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    // Get all warehouse entries
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    // Get a warehouse by ID
    public Optional<Warehouse> getWarehouseById(int id) {
        return warehouseRepository.findById(id);
    }

    // Save or update a warehouse
    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    // Delete a warehouse by ID
    public void deleteWarehouse(int id) {
        warehouseRepository.deleteById(id);
    }

}
package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.Shipment;
import com.example._Found.__Found_Group_Assignment.Repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private InventoryService inventoryService;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Transactional
    public Shipment createShipment(Shipment shipment) {
        int productId = shipment.getProduct().getId();
        int warehouseId = shipment.getWarehouse().getId();
        int shipUpdate = shipment.getQuantityShipped() * -1;

        inventoryService.updateStock(productId, warehouseId, shipUpdate);

        if (shipment.getShipmentDate() == null) {
            shipment.setShipmentDate(LocalDateTime.now());
        }
        return shipmentRepository.save(shipment);
    }
}

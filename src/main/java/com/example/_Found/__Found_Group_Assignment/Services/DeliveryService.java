package com.example._Found.__Found_Group_Assignment.Services;

import com.example._Found.__Found_Group_Assignment.Models.Delivery;
import com.example._Found.__Found_Group_Assignment.Repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private InventoryService inventoryService;

   public List<Delivery> getAllDeliveries() {
    return deliveryRepository.findAll();
   }

   // Saves new delivery as pending. Stock is not added until accepted.
   public void saveDelivery(Delivery delivery) {
       delivery.setStatus("PENDING");
       deliveryRepository.save(delivery);
   }

   // changes from pending to received
   @Transactional
    public Delivery deliveryProcess(Long deliveryId) {
       // Finds the delivery id
        Optional<Delivery> optDel = deliveryRepository.findById(deliveryId);

        if (optDel.isPresent()) {
            Delivery delivery = optDel.get();

            // Processes only id hasnt been received yet
            if (!"RECEIVED".equalsIgnoreCase(delivery.getStatus())) {
                // Uses updateStock to update attr
                inventoryService.updateStock(
                        delivery.getProduct().getId(),
                        delivery.getWarehouse().getId(),
                        delivery.getQuantityReceived()
                );
                delivery.setStatus("RECEIVED");
            }

            // saves updated delivery
            return deliveryRepository.save(delivery);
        } else {
            return null;
        }
   }
}

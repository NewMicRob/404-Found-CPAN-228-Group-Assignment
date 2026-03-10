package com.example._Found.__Found_Group_Assignment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_supplies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSupply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    private Integer quantityReceived;
    private Double unitCost;
    private LocalDateTime supplyDate;

    private String suppliedBy;
    private String status;
}

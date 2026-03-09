package com.example._Found.__Found_Group_Assignment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "warehouses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int warehouseID_id;

    @Size(min = 2, max = 240, message = "Name size must be > 2 and <240")
    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

}

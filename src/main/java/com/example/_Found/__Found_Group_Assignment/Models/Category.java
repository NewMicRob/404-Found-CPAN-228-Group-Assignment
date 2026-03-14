package com.example._Found.__Found_Group_Assignment.Models;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max = 240, message = "Name size must be > 2 and <240")
    @NotBlank(message = "The name is required")
    private String name;

    // Self-referencing parent category
    @ManyToOne
    @JoinColumn(name = "parent_id") // FK to the same table
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> items;

    public int getTotalItems() {
        int count = (items != null) ? items.size() : 0;
        if (children != null) {
            for (Category child : children) {
                count += child.getTotalItems();
            }
        }
        return count;
    }
}
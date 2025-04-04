package com.example.demo.request;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import com.example.demo.model.Category;

import java.math.BigDecimal;

@Data
public class AddProductRequest  {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="category_id")
    public Category category;
}

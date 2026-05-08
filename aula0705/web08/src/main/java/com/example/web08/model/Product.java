package com.example.web08.model;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Product name is required.")
    @Size(max = 60, message = "the name must contain a maximum of 60 characters.")
    @Column(name = "name", nullable = false, length = 60)
    private String name;
    @NotBlank(message = "Brand is required.")
    @Size(min = 2, message = "the name must contain a minimum of 2 characters.")
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @NotBlank(message = "Made in is required.")
    @Size(min = 2, message = "the name must contain a minimum of 2 characters.")
    @Column(name = "madein", nullable = false, length = 45)
    private String madein;
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(name="price", precision = 7, scale = 2, nullable = false)
    private BigDecimal price;
}
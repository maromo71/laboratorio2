package com.example.web08.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100) // BCrypt gera hashes longos
    private String password;
    
    @Column(nullable = false)
    private String role; // Ex: "ROLE_ADMIN" ou "ROLE_USER"
}

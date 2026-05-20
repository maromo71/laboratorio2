package com.example.web08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.web08.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

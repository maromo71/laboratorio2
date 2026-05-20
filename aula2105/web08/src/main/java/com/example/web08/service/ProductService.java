package com.example.web08.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.web08.model.Product;
import com.example.web08.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> listAll(){
        return (List<Product>) repo.findAll();
    }

    public void save(Product product){
        repo.save(product);
    }

    public Product get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}

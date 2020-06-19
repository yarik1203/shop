package com.example.magazyn.service;

import com.example.magazyn.model.Category;
import com.example.magazyn.model.Product;
import com.example.magazyn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public class ProductService {

    private  final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(int id) {
        return productRepository.findById(id);
    }

    public Page<Product> getAllEventsByCategory(Pageable pageable, Category category) {
        return productRepository.findAllByCategory(pageable, category);
    }
}

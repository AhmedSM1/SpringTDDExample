package com.tdd.example.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return repository.save(productEntity);
    }

    @Override
    public boolean deleteProduct(String productId) {
        return false;
    }

    @Override
    public Optional<ProductEntity> findByID(String productId) {
        return repository.findById(productId);
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean updateProduct(ProductEntity productEntity) {
        return false;
    }
}

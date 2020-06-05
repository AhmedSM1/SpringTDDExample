package com.tdd.example.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ProductService {
    ProductEntity createProduct(ProductEntity productEntity);

    boolean deleteProduct(String productId);

    Optional<ProductEntity> findByID(String productId);

    List<ProductEntity> findAll();

    boolean updateProduct(ProductEntity productEntity);

}

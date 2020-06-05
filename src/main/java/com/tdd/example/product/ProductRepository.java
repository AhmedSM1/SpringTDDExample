package com.tdd.example.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<ProductEntity,String> {
    List<ProductEntity> findAll();



}

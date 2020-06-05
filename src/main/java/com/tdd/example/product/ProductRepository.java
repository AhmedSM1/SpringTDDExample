package com.tdd.example.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends CrudRepository<ProductEntity,String> {
    List<ProductEntity> findAll();

    @Modifying
    @Query("UPDATE ProductEntity p SET p = :product ")
    void updateProduct(@Param("product") ProductEntity product );



}

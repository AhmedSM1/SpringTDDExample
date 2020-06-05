package com.tdd.example.RepositoryTest;


import com.tdd.example.product.ProductEntity;
import com.tdd.example.product.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class ProductRepositoryTest {


    @Autowired
    private ProductRepository underTest;


    @Test
    @DisplayName("Repository Test save product   Success")
    void shouldSaveProduct(){
        // Given
        // When
        // Then
    }




}

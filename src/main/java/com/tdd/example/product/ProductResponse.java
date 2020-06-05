package com.tdd.example.product;

import java.util.UUID;

public class ProductResponse {
    private UUID id;

    public ProductResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}

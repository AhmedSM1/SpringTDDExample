package com.tdd.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tdd.example.data.Customer;



public class CreateCustomerRequest {
    private final Customer customer;

    public CreateCustomerRequest(
            @JsonProperty(value = "customer") Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "CreateCustomerRequest{" +
                "customer=" + customer +
                '}';
    }
}

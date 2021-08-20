package com.tdd.example.service;

import com.tdd.example.controller.dto.CreateCustomerRequest;

import java.util.UUID;

public interface CustomerService {

    UUID createCustomer(CreateCustomerRequest createCustomerRequest);



}

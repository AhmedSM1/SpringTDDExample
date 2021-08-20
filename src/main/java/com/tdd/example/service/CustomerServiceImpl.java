package com.tdd.example.service;

import com.tdd.example.controller.dto.CreateCustomerRequest;
import com.tdd.example.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UUID createCustomer(CreateCustomerRequest createCustomerRequest) {
        return UUID.randomUUID();
    }
}

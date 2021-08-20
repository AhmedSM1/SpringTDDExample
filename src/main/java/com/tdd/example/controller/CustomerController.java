package com.tdd.example.controller;

import com.tdd.example.controller.dto.CreateCustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/Customers")
public class CustomerController {


    @PostMapping(value = "/signup")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void signUp(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){

    }

}

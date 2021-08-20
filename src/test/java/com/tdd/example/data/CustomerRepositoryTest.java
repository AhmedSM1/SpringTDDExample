package com.tdd.example.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    @Test
    void itShouldFindByPhoneNumber() {
        //Given
        Customer mockCustomer = mockCustomer();
        underTest.save(mockCustomer);
        //When
        Optional<Customer> customer = underTest.findByPhoneNumber(mockCustomer.getPhoneNumber());
        //Then
        assertThat(customer)
                .isPresent();

    }

    @Test
    void itShouldSaveCustomer() {
        //Given
        Customer mockCustomer = mockCustomer();
        //When
        underTest.save(mockCustomer);
        //Then
        Optional<Customer> customerOptional = underTest.findById(mockCustomer.getId());
        assertThat(customerOptional)
                .isPresent()
                .hasValueSatisfying(customer -> assertThat(customer).isEqualToComparingFieldByField(mockCustomer));
    }


    private Customer mockCustomer(){
        return new Customer(UUID.randomUUID(),"Ahmed","055");
    }
}

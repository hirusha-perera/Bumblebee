package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setCustomer_id(1);
        customer.setCustomer_firstName("John");
        customer.setCustomer_lastName("Doe");
        customer.setCustomer_nic("1234567890");
        customer.setCustomer_dob(Date.valueOf("1990-01-01"));
        customer.setCustomer_email("john.doe@example.com");
        customer.setCustomer_telephone("1234567890");
        customer.setCustomer_address("123 Main St");
        customer.setCustomer_state("CA");
        customer.setCustomer_password("password123");
    }

    @Test
    public void testSaveCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);

        assertEquals(customer, savedCustomer);
    }

    @Test
    public void testGetCustomer() {
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer retrievedCustomer = customerService.get(1);

        assertEquals(customer, retrievedCustomer);
    }

    @Test
    public void testDeleteCustomer() {
        customerService.deleteCustomer(1);

        verify(customerRepository, times(1)).deleteById(1);
    }

    @Test
    public void testLogin() throws AuthenticationException {
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer retrievedCustomer = customerService.login(1, "password123");

        assertEquals(customer, retrievedCustomer);
    }
}
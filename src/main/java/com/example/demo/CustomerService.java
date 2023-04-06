package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
    public Customer saveCustomer(Customer customer) {
        String hashedPassword = new BCryptPasswordEncoder().encode(customer.getCustomer_password());
        customer.setCustomer_password(hashedPassword);
        return customerRepository.save(customer);
    }
    
    public Customer get(Integer customer_id) {
        return customerRepository.findById(customer_id).get();
    }
    
    public List<Customer> listall() {
        return customerRepository.findAll();
    }
    
    public void deleteCustomer(int customer_id) {
        customerRepository.deleteById(customer_id);
    }
    
    public Customer login(Integer customer_id, String customer_password) throws AuthenticationException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer_id);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			if (new BCryptPasswordEncoder().matches(customer_password, customer.getCustomer_password())) {
				return customer;
			}
		}
		throw new AuthenticationException("Invalid customer ID or password");
	}
    
//    public List<Object[]> getCountByCustomerState() {
//        return customerRepository.getCountByCustomerState();
//    }
    public long getTotalCustomerCount() {
        return customerRepository.count();
    }
    
}

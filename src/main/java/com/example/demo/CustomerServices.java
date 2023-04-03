package com.example.demo;

//import java.sql.Date;
//import java.time.LocalDateTime;
//import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {
	
	private CustomerRepository customerRepository;
	
	public List<Customer> listAll() {
        return customerRepository.findAll();
    }
	
	public Customer get(Integer customer_id) {
		return customerRepository.findById(customer_id).get();
	}
 
//    public Optional<Customer> getCustomerById(Integer customer_id) {
//        return customerRepository.findById(customer_id);
//    }
 
//    public Optional<Customer> getCustomerByEmail(String customer_email) {
//        return customerRepository.findByCustomer_email(customer_email);
//    }
	
	public void save(Customer customer) {
		customer.setCustomer_password(BCrypt.hashpw(customer.getCustomer_password(), BCrypt.gensalt()));
		customerRepository.save(customer);
	}
 
//    public Customer createCustomer(Customer customer) {
//        customer.setCustomer_password(BCrypt.hashpw(customer.getCustomer_password(), BCrypt.gensalt()));
//        //customer.setCustomer_registeredDate(new (LocalDateTime.now());
//        return customerRepository.save(customer);
//    }
 
    public Customer updateCustomer(Integer customer_id, Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer_id);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setCustomer_fisrtName(customer.getCustomer_fisrtName());
            existingCustomer.setCustomer_lastName(customer.getCustomer_lastName());
            existingCustomer.setCustomer_nic(customer.getCustomer_nic());
            existingCustomer.setCustomer_dob(customer.getCustomer_dob());
            existingCustomer.setCustomer_email(customer.getCustomer_email());
            existingCustomer.setCustomer_telephone(customer.getCustomer_telephone());
            existingCustomer.setCustomer_address(customer.getCustomer_address());
           
            existingCustomer.setCustomer_state(customer.getCustomer_state());
            return customerRepository.save(existingCustomer);
        } else {
            throw new EntityNotFoundException("Customer not found with id " + customer_id);
        }
    }
 
    public void deleteCustomer(Integer customer_id) {
        customerRepository.deleteById(customer_id);
    }
 
//    public boolean verifyPassword(String customer_password, String hashedPassword) {
//        return BCrypt.checkpw(customer_password, hashedPassword);
//    }
//    public Customer login(String customer_email, String customer_password) {
//        Optional<Customer> optionalCustomer = customerRepository.findByCustomer_email(customer_email);
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            if (verifyPassword(customer_password, customer.getCustomer_password())) {
//                return customer;
//            }
//        }
//        return null;
//        }


}

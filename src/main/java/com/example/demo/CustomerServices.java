package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerServices {
	
	private CustomerRepository repos;
	
	public List<Customer> listAll(){
		return repos.findAll();
	}
	
	public void save(Customer customer) {
		repos.save(customer);
	}
	
	public Customer get(Integer customer_id) {
		return repos.findById(customer_id).get();
	}
	
	public void delete(Integer customer_id) {
		repos.deleteById(customer_id);
	}

}

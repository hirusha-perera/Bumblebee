package controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.Admin;
import com.example.demo.Customer;
import com.example.demo.CustomerServices;



@RestController
public class CustomerController {
	
	@Autowired
    private CustomerServices services;

	@ExceptionHandler(Exception.class)
	@GetMapping("/customer")
	public List<Customer> list() {
		
		return services.listAll();
	}
	
	@GetMapping("/customer/{customer_id}")
	public ResponseEntity<Customer> get(@PathVariable Integer customer_id) {
		try {
		Customer customer = services.get(customer_id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/customer")
	public void add(@RequestBody Customer customer) {
		services.save(customer);
	}
	
	@PutMapping("/customer/{customer_id}")
	public ResponseEntity<?> update(@RequestBody Customer customer,
			@PathVariable Integer customer_id) {
		try {
			Customer exsistCustomer = services.get(customer_id);
			services.save(customer);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/customer/{customer_id}")
	public void delete(@PathVariable Integer customer_id) {
		services.delete(customer_id);
	}

}

package controller;

//import java.net.URI;
import java.util.List;
//import java.util.Map;
import java.util.NoSuchElementException;
//import java.util.NoSuchElementException;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Customer;
import com.example.demo.CustomerServices;



@RestController
public class CustomerController {
	
	@Autowired
    private CustomerServices customerService;

	@ExceptionHandler(Exception.class)
	
	@GetMapping("/customer")
    public List<Customer> list() {
        return customerService.listAll();
    }
	
//	 @GetMapping("/customer/{customer_id}")
//	    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customer_id) {
//	        Optional<Customer> optionalCustomer = customerService.getCustomerById(customer_id);
//	        if (optionalCustomer.isPresent()) {
//	            return ResponseEntity.ok(optionalCustomer.get());
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
	 
		@GetMapping("/customer/{customer_id}")
		public ResponseEntity<Customer> get(@PathVariable Integer customer_id) {
			try {
			Customer customer = customerService.get(customer_id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			}
		}
	 
		@PostMapping("/customer")
		public void add(@RequestBody Customer customer) {
			customerService.save(customer);
		}
	
//	   @PostMapping("/customer")
//	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//	        Customer createdCustomer = customerService.createCustomer(customer);
//	        return ResponseEntity.created(URI.create("/api/customers/" + createdCustomer.getCustomer_id()))
//	                .body(createdCustomer);
//	    }
		
		
		@PutMapping("/customer/{customer_id}")
		public ResponseEntity<?> update(@RequestBody Customer customer,
				@PathVariable Integer customer_id) {
			try {
				Customer exsistCustomer = customerService.get(customer_id);
				customerService.save(customer);
				
				return new ResponseEntity<>(HttpStatus.OK);
			}catch (NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	
//	   @PutMapping("/customer/{customer_id}")
//	    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customer_id, @RequestBody Customer customer) {
//	        Customer updatedCustomer = customerService.updateCustomer(customer_id, customer);
//	        return ResponseEntity.ok(updatedCustomer);
//	    }
//	
		
		@DeleteMapping("/customer/{customer_id}")
		public void delete(@PathVariable Integer customer_id) {
			customerService.deleteCustomer(customer_id);
		}
		
		
//	   @DeleteMapping("/customer/{customer_id}")
//	    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customer_id) {
//	        customerService.deleteCustomer(customer_id);
//	        return ResponseEntity.noContent().build();
//	    }
	   
	   
//	   @PostMapping("/customer/login")
//	    public ResponseEntity<Void> login(@RequestBody Map<String, String> credentials) {
//	        String customer_email = credentials.get("customer_email");
//	        String customer_password = credentials.get("customer_password");
//	        Optional<Customer> optionalCustomer = customerService.findByCustomer_email(customer_email);
//	        if (optionalCustomer.isPresent()) {
//	            Customer customer = optionalCustomer.get();
//	            if (BCrypt.checkpw(customer_password, customer.getCustomer_password())) {
//	                return ResponseEntity.ok().build();
//	            }
//	        }
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//	    }

}

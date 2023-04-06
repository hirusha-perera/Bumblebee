package controller;

import java.util.List;
import java.util.Optional;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Customer;
import com.example.demo.CustomerLoginRequest;
import com.example.demo.CustomerService;

import exception.CustomerNotFoundException;

import com.example.demo.CustomerRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	

	  @GetMapping("/customers/count")
	    public ResponseEntity<Long> getTotalCustomerCount() {
	        long count = customerService.getTotalCustomerCount();
	        return ResponseEntity.ok(count);
	    }

	   
	
	  @GetMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return customerService.listall();
	    }
	  
	  @GetMapping("/customers/{customer_id}")
	    public Customer getCustomerById(@PathVariable int customer_id) {
	        return customerService.get(customer_id);
	        
	        
	        
	    }
	
	  @PostMapping("/customers")
	    public Customer createCustomer(@Valid @RequestBody Customer customer) {
	        return customerService.saveCustomer(customer);

	    }
	  
	  
	  
	  	  @PutMapping("/customers/{customer_id}")
	  Customer updateCustomer (@RequestBody Customer customer, @PathVariable Integer customer_id) {
		  return customerRepository.findById(customer_id)
				  
				  .map(existingCustomer ->{
					  existingCustomer.setCustomer_firstName(customer.getCustomer_firstName());
				        existingCustomer.setCustomer_lastName(customer.getCustomer_lastName());
				        existingCustomer.setCustomer_nic(customer.getCustomer_nic());
				       // existingCustomer.setCustomer_dob(customer.'01.01.2001');
				        existingCustomer.setCustomer_email(customer.getCustomer_email());
				        existingCustomer.setCustomer_telephone(customer.getCustomer_telephone());
				        existingCustomer.setCustomer_address(customer.getCustomer_address());
				        existingCustomer.setCustomer_state(customer.getCustomer_state());
			        
				        return customerRepository.save(existingCustomer);
				  }).orElseThrow(()->new CustomerNotFoundException(customer_id));
				  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	       
	  @DeleteMapping("/customers/{customer_id}")
	    public void deleteCustomer(@PathVariable int customer_id) {
	        customerService.deleteCustomer(customer_id);
	    }
	  
	  
	  
	  @PostMapping("/customers/login")
		public ResponseEntity<?> login(@RequestBody CustomerLoginRequest loginRequest) {
			try {
				Customer customer = customerService.login(loginRequest.getCustomer_id(), loginRequest.getCustomer_password());
				return ResponseEntity.ok(customer);
			} catch (AuthenticationException e) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
			}
		}
	  
	  
//	  @GetMapping("/customer/count-by-state")
//	    public List<Object[]> getCountByCustomerState() {
//	        return customerService.getCountByCustomerState();
//	    }


}

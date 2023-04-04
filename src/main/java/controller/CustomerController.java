package controller;

import java.util.List;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
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


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	

	   
	   
	
	  @GetMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return customerService.listall();
	    }
	  
	  @GetMapping("/customers/{customer_id}")
	    public Customer getCustomerById(@PathVariable int customer_id) {
	        return customerService.get(customer_id);
	    }
	
	  @PostMapping("/customers")
	    public Customer createCustomer(@RequestBody Customer customer) {
	        return customerService.saveCustomer(customer);

	    }
	  
	  @PutMapping("/customers/{customer_id}")
	    public Customer updateCustomer(@PathVariable int customer_id, @RequestBody Customer customer) {
	        Customer existingCustomer = customerService.get(customer_id);
	        existingCustomer.setCustomer_firstName(customer.getCustomer_firstName());
	        existingCustomer.setCustomer_lastName(customer.getCustomer_lastName());
	        existingCustomer.setCustomer_nic(customer.getCustomer_nic());
	        existingCustomer.setCustomer_dob(customer.getCustomer_dob());
	        existingCustomer.setCustomer_email(customer.getCustomer_email());
	        existingCustomer.setCustomer_telephone(customer.getCustomer_telephone());
	        existingCustomer.setCustomer_address(customer.getCustomer_address());
	        existingCustomer.setCustomer_state(customer.getCustomer_state());
	        existingCustomer.setCustomer_password(customer.getCustomer_password());
	        return customerService.saveCustomer(existingCustomer);
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

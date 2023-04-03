package com.example.demo;

//import java.util.Optional;
//import com.example.demo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	//Optional<Customer> findByCustomer_email(String customer_email);

}

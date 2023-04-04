package com.example.demo;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	//Customer findByCustomerId(int customer_id);
	
//    @Query("SELECT customer_state, COUNT(*) FROM customers GROUP BY customer_state")
//    List<Object[]> getCountByCustomerState();

}

package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsServices {
	
	private static PaymentsServices instance = null;
	
	@Autowired
	private PaymentsRepository paymentRepository;
	
	  private PaymentsServices() {
	       
	    }
	    
	    public static PaymentsServices getInstance() {
	        if (instance == null) {
	            instance = new PaymentsServices();
	        }
	        return instance;
	    }
	
	public List<Payments> listAll(){
		return paymentRepository.findAll();
	}
	
	public void save(Payments payments) {
		paymentRepository.save(payments);
	}
	
	public Payments get(Integer payment_id) {
		return paymentRepository.findById(payment_id).get();
	}
	
	public Payments getbycus(Integer customerpay_id) {
		return paymentRepository.findById(customerpay_id).get();
	}
	
	public Payments getbypurchase(Integer purchased_id) {
		return paymentRepository.findById(purchased_id).get();
	}
	
	public void delete(Integer payment_id) {
		paymentRepository.deleteById(payment_id);
	}
	
	
}

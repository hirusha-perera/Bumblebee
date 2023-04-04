package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServices {
	

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public List<Purchase> listAll(){
		return purchaseRepository.findAll();
	}
	
	public void save(Purchase purchase) {
		purchaseRepository.save(purchase);
	}
	
	public Purchase get(Integer purchase_id) {
		return purchaseRepository.findById(purchase_id).get();
	}
	
	public Purchase getbycus(Integer purchased_customer) {
		return purchaseRepository.findById(purchased_customer).get();
	}
	

	
	public void delete(Integer admin_id) {
		purchaseRepository.deleteById(admin_id);
	}

}

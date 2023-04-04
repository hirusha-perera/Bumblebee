package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CusAccountServices {
	
	
	@Autowired
	private CusAccountRepository cusAccountRepository;
	
	public List<CusAccount> listAll(){
		return cusAccountRepository.findAll();
	}
	
	public void save(CusAccount cusaccount) {
		cusAccountRepository.save(cusaccount);
	}
	
	public CusAccount get(Integer cus_id) {
		return cusAccountRepository.findById(cus_id).get();
	}

	
	public void delete(Integer cus_id) {
		cusAccountRepository.deleteById(cus_id);
	}

}

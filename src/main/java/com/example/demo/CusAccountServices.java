package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CusAccountServices {
	
	private static CusAccountServices instance = null;
	
	@Autowired
	private CusAccountRepository cusAccountRepository;
	
	private CusAccountServices() {
	       
    }
    
    public static CusAccountServices getInstance() {
        if (instance == null) {
            instance = new CusAccountServices();
        }
        return instance;
    }
	
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

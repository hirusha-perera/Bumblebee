package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import config.AdminSecurityConfig;

@Service
public class AdminServices {
	

	
	
	@Autowired
	private AdminRepository repos;
	
	public List<Admin> listAll(){
		return repos.findAll();
	}
	
	public void save(Admin admin) {
		repos.save(admin);
	}
	
	public Admin get(Integer admin_id) {
		return repos.findById(admin_id).get();
	}
	
	public void delete(Integer admin_id) {
		repos.deleteById(admin_id);
	}
	
	
	}



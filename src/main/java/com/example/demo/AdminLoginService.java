package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminLoginService implements UserDetailsService {
	
	@Autowired
	private AdminRepository repo;

	@Override
	public UserDetails loadUserByUsername(String admin_email) throws UsernameNotFoundException {

		Admin admin = repo.findByEmail(admin_email);
		
		if(admin == null) {
			throw new UsernameNotFoundException("Admin not Found");
		}
return null;

	}

}

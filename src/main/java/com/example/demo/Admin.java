package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	private Integer admin_id;
	private String admin_name;
	private String admin_email;
	private String admin_telephone;
	private String admin_password;
	
	
	
	public Admin() {
		
	}
	public Admin(Integer admin_id, String admin_name, String admin_email, String admin_telephone,
			String admin_password) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_email = admin_email;
		this.admin_telephone = admin_telephone;
		this.admin_password = admin_password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id generate automatically by database
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_telephone() {
		return admin_telephone;
	}
	public void setAdmin_telephone(String admin_telephone) {
		this.admin_telephone = admin_telephone;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}


	

}

package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	private Integer customer_id;
	private String customer_fisrtName;
	private String customer_lastName;
	private String customer_nic;
	private LocalDate customer_dob;
	private String customer_email;
	private String customer_telephone;
	private String customer_address1;
	private String customer_address2;
	private String customer_state;
	private String customer_password;
	private LocalDateTime customer_registeredDate;
	
	public Customer() {

	}

	public Customer(Integer customer_id, String customer_fisrtName, String customer_lastName, String customer_nic,
			LocalDate customer_dob, String customer_email, String customer_telephone, String customer_address1,
			String customer_address2, String customer_state, String customer_password,
			LocalDateTime customer_registeredDate) {
		super();
		this.customer_id = customer_id;
		this.customer_fisrtName = customer_fisrtName;
		this.customer_lastName = customer_lastName;
		this.customer_nic = customer_nic;
		this.customer_dob = customer_dob;
		this.customer_email = customer_email;
		this.customer_telephone = customer_telephone;
		this.customer_address1 = customer_address1;
		this.customer_address2 = customer_address2;
		this.customer_state = customer_state;
		this.customer_password = customer_password;
		this.customer_registeredDate = customer_registeredDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id generate automatically by database
	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_fisrtName() {
		return customer_fisrtName;
	}

	public void setCustomer_fisrtName(String customer_fisrtName) {
		this.customer_fisrtName = customer_fisrtName;
	}

	public String getCustomer_lastName() {
		return customer_lastName;
	}

	public void setCustomer_lastName(String customer_lastName) {
		this.customer_lastName = customer_lastName;
	}

	public String getCustomer_nic() {
		return customer_nic;
	}

	public void setCustomer_nic(String customer_nic) {
		this.customer_nic = customer_nic;
	}

	public LocalDate getCustomer_dob() {
		return customer_dob;
	}

	public void setCustomer_dob(LocalDate customer_dob) {
		this.customer_dob = customer_dob;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_telephone() {
		return customer_telephone;
	}

	public void setCustomer_telephone(String customer_telephone) {
		this.customer_telephone = customer_telephone;
	}

	public String getCustomer_address1() {
		return customer_address1;
	}

	public void setCustomer_address1(String customer_address1) {
		this.customer_address1 = customer_address1;
	}

	public String getCustomer_address2() {
		return customer_address2;
	}

	public void setCustomer_address2(String customer_address2) {
		this.customer_address2 = customer_address2;
	}

	public String getCustomer_state() {
		return customer_state;
	}

	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public LocalDateTime getCustomer_registeredDate() {
		return customer_registeredDate;
	}

	public void setCustomer_registeredDate(LocalDateTime customer_registeredDate) {
		this.customer_registeredDate = customer_registeredDate;
	}
	
	
	
	

}

package com.example.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
	@Column(name = "customer_id")
	private Integer customer_id;
	
	@Column(name = "customer_firstName")
	@NotNull(message = "First Name cannot be blank")
	private String customer_firstName;
	
	@Column(name = "customer_lastName")
	@NotNull(message = "Last First Name cannot be blank")
	private String customer_lastName;
	
	@Column(name = "customer_nic")
	@NotNull(message = "NIC number cannot be blank")
    @Size(min = 10, max = 12, message = "NIC number should be between 10 and 12 characters")
	private String customer_nic;
	
	@Column(name = "customer_dob")
	@NotNull(message = "Date of birth is required")
	private Date customer_dob;
	
	@Column(name = "customer_email")
	@Email(message = "Invalid email address")
	private String customer_email;
	
	@Column(name = "customer_telephone")
	@NotNull(message = "Telephone Number cannot be blank")
	private String customer_telephone;
	
	@Column(name = "customer_address")
	@NotNull(message = "Address cannot be blank")
	private String customer_address;
	
	@Column(name = "customer_state")
	@NotNull(message = "State cannot be blank")
	private String customer_state;
	
	@Column(name = "customer_password")
	@NotNull(message = "Please set a  password")
	private String customer_password;
	
	public Customer() {
		
	}

	public Customer(Integer customer_id, String customer_firstName, String customer_lastName, String customer_nic,
			Date customer_dob, String customer_email, String customer_telephone, String customer_address,
			String customer_state, String customer_password) {
		super();
		this.customer_id = customer_id;
		this.customer_firstName = customer_firstName;
		this.customer_lastName = customer_lastName;
		this.customer_nic = customer_nic;
		this.customer_dob = customer_dob;
		this.customer_email = customer_email;
		this.customer_telephone = customer_telephone;
		this.customer_address = customer_address;
		this.customer_state = customer_state;
		this.customer_password = customer_password;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	

	public String getCustomer_firstName() {
		return customer_firstName;
	}

	public void setCustomer_firstName(String customer_firstName) {
		this.customer_firstName = customer_firstName;
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

	public Date getCustomer_dob() {
		return customer_dob;
	}

	public void setCustomer_dob(Date customer_dob) {
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

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
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
	
	
	
	

}

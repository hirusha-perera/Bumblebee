package com.example.demo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cus_account")
public class CusAccount {
	
	private Integer cus_id;
	private  BigDecimal cus_limit;
	private BigDecimal cus_used;
	private BigDecimal cus_balance;
	
	
	public CusAccount() {
		
	}


	public CusAccount(Integer cus_id, BigDecimal cus_limit, BigDecimal cus_used, BigDecimal cus_balance) {
		super();
		this.cus_id = cus_id;
		this.cus_limit = cus_limit;
		this.cus_used = cus_used;
		this.cus_balance = cus_balance;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCus_id() {
		return cus_id;
	}


	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}


	public BigDecimal getCus_limit() {
		return cus_limit;
	}


	public void setCus_limit(BigDecimal cus_limit) {
		this.cus_limit = cus_limit;
	}


	public BigDecimal getCus_used() {
		return cus_used;
	}


	public void setCus_used(BigDecimal cus_used) {
		this.cus_used = cus_used;
	}


	public BigDecimal getCus_balance() {
		return cus_balance;
	}


	public void setCus_balance(BigDecimal cus_balance) {
		this.cus_balance = cus_balance;
	}
	
	
	
	
	
	
	

}

package com.example.demo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {
	
	private Integer purchase_id;
	private Integer purchased_customer;
	private String purchased_product;
	private Integer purchased_quantity;
	private BigDecimal purchased_amount;
	private BigDecimal installment_amount;
	private Date purchased_date;
	
	public Purchase() {

	}


	public Purchase(Integer purchase_id, Integer purchased_customer, String purchased_product,
			Integer purchased_quantity, BigDecimal purchased_amount, BigDecimal installment_amount, Date purchased_date) {
		super();
		this.purchase_id = purchase_id;
		this.purchased_customer = purchased_customer;
		this.purchased_product = purchased_product;
		this.purchased_quantity = purchased_quantity;
		this.purchased_amount = purchased_amount;
		this.installment_amount = installment_amount;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPurchase_id() {
		return purchase_id;
	}


	public void setPurchase_id(Integer purchase_id) {
		this.purchase_id = purchase_id;
	}


	public Integer getPurchased_customer() {
		return purchased_customer;
	}


	public void setPurchased_customer(Integer purchased_customer) {
		this.purchased_customer = purchased_customer;
	}


	public String getPurchased_product() {
		return purchased_product;
	}


	public void setPurchased_product(String purchased_product) {
		this.purchased_product = purchased_product;
	}


	public Integer getPurchased_quantity() {
		return purchased_quantity;
	}


	public void setPurchased_quantity(Integer purchased_quantity) {
		this.purchased_quantity = purchased_quantity;
	}


	public BigDecimal getPurchased_amount() {
		return purchased_amount;
	}


	public void setPurchased_amount(BigDecimal purchased_amount) {
		this.purchased_amount = purchased_amount;
	}


	public BigDecimal getInstallment_amount() {
		return installment_amount;
	}


	public void setInstallment_amount(BigDecimal installment_amount) {
		this.installment_amount = installment_amount;
	}


	public Date getPurchased_date() {
		return purchased_date;
	}


	public void setPurchased_date(Date purchased_date) {
		this.purchased_date = purchased_date;
	}
	
	
	
	
	
	

}

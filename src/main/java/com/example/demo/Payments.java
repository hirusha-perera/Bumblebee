package com.example.demo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
	
	private Integer payment_id;
	private Integer purchased_id;
	private Integer customerpay_id;
	private BigDecimal total_amount;
	private BigDecimal first_installment;
	private Date first_installmentDate;
	private BigDecimal second_installment;
	private Date second_installmentDate;
	private BigDecimal third_installment;
	private Date third_installmentDate;
	
	
	public Payments() {
		
	}


	public Payments(Integer payment_id, Integer purchased_id, Integer customerpay_id, BigDecimal total_amount,
			BigDecimal first_installment, Date first_installmentDate, BigDecimal second_installment,
			Date second_installmentDate, BigDecimal third_installment, Date third_installmentDate) {
		super();
		this.payment_id = payment_id;
		this.purchased_id = purchased_id;
		this.customerpay_id = customerpay_id;
		this.total_amount = total_amount;
		this.first_installment = first_installment;
		this.first_installmentDate = first_installmentDate;
		this.second_installment = second_installment;
		this.second_installmentDate = second_installmentDate;
		this.third_installment = third_installment;
		this.third_installmentDate = third_installmentDate;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}


	public Integer getPurchased_id() {
		return purchased_id;
	}


	public void setPurchased_id(Integer purchased_id) {
		this.purchased_id = purchased_id;
	}


	public Integer getCustomerpay_id() {
		return customerpay_id;
	}


	public void setCustomerpay_id(Integer customerpay_id) {
		this.customerpay_id = customerpay_id;
	}


	public BigDecimal getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}


	public BigDecimal getFirst_installment() {
		return first_installment;
	}


	public void setFirst_installment(BigDecimal first_installment) {
		this.first_installment = first_installment;
	}


	public Date getFirst_installmentDate() {
		return first_installmentDate;
	}


	public void setFirst_installmentDate(Date first_installmentDate) {
		this.first_installmentDate = first_installmentDate;
	}


	public BigDecimal getSecond_installment() {
		return second_installment;
	}


	public void setSecond_installment(BigDecimal second_installment) {
		this.second_installment = second_installment;
	}


	public Date getSecond_installmentDate() {
		return second_installmentDate;
	}


	public void setSecond_installmentDate(Date second_installmentDate) {
		this.second_installmentDate = second_installmentDate;
	}


	public BigDecimal getThird_installment() {
		return third_installment;
	}


	public void setThird_installment(BigDecimal third_installment) {
		this.third_installment = third_installment;
	}


	public Date getThird_installmentDate() {
		return third_installmentDate;
	}


	public void setThird_installmentDate(Date third_installmentDate) {
		this.third_installmentDate = third_installmentDate;
	}
	
	
	

}

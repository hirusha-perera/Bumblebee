package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

	private Integer product_id;
	private String product_name;
	private String product_description;
	private Integer product_quantity;
	private String product_price;
	   @Lob
	   
	    private byte[] product_image;

	public Product() {
		
	}

	public Product(Integer product_id, String product_name, String product_description, Integer product_quantity,
			String product_price,byte[] product_image) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_quantity = product_quantity;
		this.product_price = product_price;
		this.product_image = product_image;
	}
	



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id generate automatically by database
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public byte[] getProduct_image() {
		return product_image;
	}

	public void setProduct_image(byte[] product_image) {
		this.product_image = product_image;
	}
	
	
	
}

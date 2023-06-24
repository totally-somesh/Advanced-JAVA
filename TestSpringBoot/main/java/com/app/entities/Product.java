package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;//all specs Java EE supplied


@Entity
@Table(name = "new_product") 
public class Product extends BaseEntity {

	@Column(name = "product_name", length = 20) 
	private String pName;
	
	@Column(length = 30, unique = true) 
	private Integer quantity;
	
	private Double price;
		
	@Column(length = 30)
	private String description;

	public Product() {
		
	}

	public Product(String pName, Integer quantity, Double price, String description) {
		super();
		this.pName = pName;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [pName=" + pName + ", quantity=" + quantity + ", price=" + price +", description=" + description + "]";
	}
	
	
}

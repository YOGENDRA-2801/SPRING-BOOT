package com.yoy.crudoperation.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Products {
	
	@Id
	@SequenceGenerator(name = "pro_gen" , sequenceName = "pro_seq" , initialValue = 101 , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "pro_gen")
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
    private String name;
	@Column(name = "price" , precision = 10 , scale = 2)
    private BigDecimal price;
	@Column(name = "quantity")
    private Integer quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public Products() {
		super();
	}
	public Products(String name, BigDecimal price, Integer quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Products(Long id, String name, BigDecimal price, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void display() {
		System.out.println("Product Information");
		System.out.println("ID : " + id);
		System.out.println("NAME : " + name);
		System.out.println("PRICE : " + price);
		System.out.println("QUANTITY : " + quantity);
	}
}
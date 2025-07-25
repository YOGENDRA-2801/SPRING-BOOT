package com.yoy.sbuserhubjsp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id ;
	@Column(name = "name")
	private String name ;
	@Column(name = "email")
	private String email ;
	@Column(name = "password")
	private String password ;
	@Column(name = "mobile")
	private String mobile ;
	public User() {
		super();
	}
	public User(String name, String email, String password, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	public User(long id, String name, String email, String password, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void display() {
		System.out.println(" ----- USER DETAIL ----- ");
		System.out.println("ID : " + id);
		System.out.println("NAME : " + name);
		System.out.println("EMAIL : " + email);
		System.out.println("PASSWORD : " + password);
		System.out.println("MOBILE : " + mobile);
	}
}

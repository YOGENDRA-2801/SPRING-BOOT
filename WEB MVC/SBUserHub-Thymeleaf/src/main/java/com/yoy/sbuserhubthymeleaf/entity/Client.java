package com.yoy.sbuserhubthymeleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@SequenceGenerator(
			name = "clnt_gen",
		    sequenceName = "clnt_seq",
			initialValue = 101,
			allocationSize = 1 
		)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clnt_gen")
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "mobile")
	private String mobile;

	public Client() {
		super();
	}

	public Client(String name, String email, String password, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public Client(Long id, String name, String email, String password, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

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
		System.out.println(" ----- CLIENT DETAIL ----- ");
		System.out.println("ID : " + id);
		System.out.println("NAME : " + name);
		System.out.println("EMAIL : " + email);
		System.out.println("PASSWORD : " + password);
		System.out.println("MOBILE : " + mobile);
	}
}
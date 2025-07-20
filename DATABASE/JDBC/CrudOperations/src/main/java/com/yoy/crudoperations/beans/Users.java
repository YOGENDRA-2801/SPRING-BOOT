package com.yoy.crudoperations.beans;

public class Users 
{
	private int id ;
	private String name ;
	private String religion ;
	private String city ;
	
	public Users() {
		super();
	}
	public Users(int id, String name, String religion, String city) {
		super();
		this.id = id;
		this.name = name;
		this.religion = religion;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public void display() {
		System.out.println(" ----- USER DETAILS ----- ");
		System.out.println("ID : " + id);
		System.out.println("NAME : " + name);
		System.out.println("RELIGION : " + religion);
		System.out.println("CITY : " + city);
	}
}
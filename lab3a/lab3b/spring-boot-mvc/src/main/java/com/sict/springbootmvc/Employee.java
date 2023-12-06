package com.sict.springbootmvc;

public class Employee {
	private String fname;
	private String lname;
	private int id;
	private String email;
	
	public Employee (int id, String fname, String lname, String email) {
		
		this.id = id;
		this.lname = lname;
		this.fname = fname;
		this.email = email;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

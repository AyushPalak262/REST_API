package com.udemy.rest.webservices.restfulwebservices.versioning;

public class Name {
	private String fname;
	private String lname;
	
	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Name(String fname, String lname) {
		this.fname=fname;
		this.lname=lname;
		
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	@Override
	public String toString() {
		return "Name [fname=" + fname + ", lname=" + lname + "]";
	}
}

package com.udemy.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {
	
	private String name;

	public PersonV1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}
	
	
}

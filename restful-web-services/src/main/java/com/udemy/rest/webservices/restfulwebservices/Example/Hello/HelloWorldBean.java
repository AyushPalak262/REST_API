package com.udemy.rest.webservices.restfulwebservices.Example.Hello;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		this.message = message;
	}

	
	  @Override public String toString() { 
		  return "HelloWorldBean [message=" +message + "]";
		  }
	 

}

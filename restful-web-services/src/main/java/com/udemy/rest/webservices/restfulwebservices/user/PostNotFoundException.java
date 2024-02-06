package com.udemy.rest.webservices.restfulwebservices.user;

public class PostNotFoundException extends RuntimeException {
	
	public PostNotFoundException(String message) {
		super(message);
	}
}

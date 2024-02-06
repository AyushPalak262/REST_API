package com.udemy.rest.webservices.restfulwebservices.Example.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String helloworld() {
		return "Hello world";
	}
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloworldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world,%s", name));
	}
	

}

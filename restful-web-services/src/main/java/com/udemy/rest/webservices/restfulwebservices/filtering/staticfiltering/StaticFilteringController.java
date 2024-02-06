package com.udemy.rest.webservices.restfulwebservices.filtering.staticfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {
	
	@GetMapping("/static-filtering")
	public StaticBean staticfiltering() {
		return new StaticBean("value1","value2","value3");
	}
	
	@GetMapping("/static-filtering-list")
	public List<StaticBean> staticfilteringList(){
		return Arrays.asList(new StaticBean("value1","value2","value3"),
				new StaticBean("value4","value5","value6"));
	}

}

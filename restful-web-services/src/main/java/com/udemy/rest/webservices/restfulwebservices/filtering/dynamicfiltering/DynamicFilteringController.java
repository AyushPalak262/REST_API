package com.udemy.rest.webservices.restfulwebservices.filtering.dynamicfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {
	
	@GetMapping("/dynamic-filtering") //area2
	public MappingJacksonValue dynamicfiltering() {
		
		DynamicBean dynamicBean = new DynamicBean("value1","value2", "value3");

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicBean);
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("area1","area3");
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters );
		
		
		return mappingJacksonValue;
	}
	
	

	@GetMapping("/dynamic-filtering-list") //area2, area3
	public MappingJacksonValue dynamicfilteringList() {
		
		List<DynamicBean> list = Arrays.asList(new DynamicBean("value1","value2", "value3"),
				new DynamicBean("value4","value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("area2","area3");
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters );
		
		
		return mappingJacksonValue;
	}

}

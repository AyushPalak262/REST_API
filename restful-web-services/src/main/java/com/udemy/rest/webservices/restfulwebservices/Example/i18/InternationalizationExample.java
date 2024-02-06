package com.udemy.rest.webservices.restfulwebservices.Example.i18;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalizationExample {
	
	//watch video -163/section-8/step-19
	
	private MessageSource messageSource;
	
	

	public InternationalizationExample(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}



	@GetMapping("/hello-world-internationalization")
	public String helloWorldInternationaliztion() {
		
		Locale locale=LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		
		//return "Good Morning";
	}
}

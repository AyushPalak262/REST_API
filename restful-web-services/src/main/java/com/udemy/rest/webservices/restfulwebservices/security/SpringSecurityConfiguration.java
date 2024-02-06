package com.udemy.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	//LDAP or database
	//In Memory
	
	
	
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserManagerDetail() {
		
		UserDetails userDetails1 = createNewUser("Ayush262", "Ayush@123");
		UserDetails userDetails2 = createNewUser("Ayush", "siwan@123");
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
		}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		=input -> passwordEncoder().encode(input);
		
		UserDetails userDetails=User.builder()
									.passwordEncoder(passwordEncoder)
									.username(username)
									.password(password)
									.roles("USER","ADMIN")
									.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//1)All request should be authenicated
		http.authorizeHttpRequests(
				auth ->auth.anyRequest().authenticated());
		
		//2)If a request is not authenticated ,a web page is shown
		http.httpBasic(withDefaults());
		
		//disable csfr to use POST & PUT request
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}

}

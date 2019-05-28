package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class PostClient {
	static final String URL_CREATE_USER = "http://localhost:8080/users";
	public static void main(String [] args) {
		User user = new User();
		user.setId(3);
		user.setUserName("mark.antony");
		user.setNachName("Antony");
		user.setVorName("Mark");
		user.setEmailId("mark.antony@gmx.de");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<User> requestBody = new HttpEntity<>(user, headers);
		
		User e = restTemplate.postForObject(URL_CREATE_USER, requestBody, User.class);
		
		if (e != null && e.getId() != 0) {
			System.out.println("User created " + e.getId());			
		}
		else {
			System.out.println("Something error");
		}
	}
}

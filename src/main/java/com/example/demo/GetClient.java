package com.example.demo;

import org.springframework.web.client.RestTemplate;

public class GetClient {
	static final String URL_USERS = "http://localhost:8080/users";
	static final String URL_USERS_JSON="http://localhost:8080/users.json";
	
	public static void main(String [] args) {
		RestTemplate restTemplate = 
				new RestTemplate();
		
		String result = 
				restTemplate.getForObject(URL_USERS, String.class);
		System.out.println(result);
	}

}

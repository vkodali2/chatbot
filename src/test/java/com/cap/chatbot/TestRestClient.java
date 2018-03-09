package com.cap.chatbot;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.cap.service.BasicAuthRestTemplate;

public class TestRestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UUID idOne = UUID.randomUUID();
		System.out.println("idOne ::"+idOne);
		
		BasicAuthRestTemplate restTemplate = new BasicAuthRestTemplate("summituser", "abcd");
		ResponseEntity<String> result = restTemplate.getForEntity("http://54.195.246.137/bin/trainingServlet?query=cards", String.class);
		
		System.out.println("RESULT::"+result.toString());
		
	}

}

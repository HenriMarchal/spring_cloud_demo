package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {
	//TODO get a property for the port
	private static final String URL = "http://name:7070/1";
	private final RestTemplate rest;

	public NameService(RestTemplate rest) {
		this.rest = rest;
	}

	public String getName() {
		return rest.getForObject(URL, String.class);
	}
}

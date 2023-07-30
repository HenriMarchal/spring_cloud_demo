package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {
	private static final String URL = "http://192.168.1.60:7070/1";
	private RestTemplate rest;

	public NameService(RestTemplate rest) {
		this.rest = rest;
	}

	public String getName() {
		return rest.getForObject(URL, String.class);
	}
}

package com.example.demo;

import java.util.logging.Logger;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

	@Autowired
	private GreetingDao repo;
	public GreetingController() {

	}

	@RequestMapping("/{languageCode}")
	public ResponseEntity<String> getGreeting(@PathVariable String languageCode){
		LOG.info("Language Code: " + languageCode);
		Greeting ret = repo.findByLanguageCode(languageCode);
		LOG.info("Greeting: " + ret);

		//TODO create a filter ? On http://localhost? On a external config?
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin","*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		return ResponseEntity
				.status(HttpStatus.OK)
				.headers(headers)
				.body(new Gson().toJson(ret));
	}

	@RequestMapping("/")
	public ResponseEntity<String> getGreeting(){
		Greeting ret = repo.findByLanguageCode("");
		LOG.info("Greeting: " + ret);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin","*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		return ResponseEntity
				.status(HttpStatus.OK)
				.headers(headers)
				.body(new Gson().toJson(ret));
	}

}

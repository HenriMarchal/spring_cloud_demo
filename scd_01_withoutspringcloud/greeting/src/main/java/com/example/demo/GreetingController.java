package com.example.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

		//Fake load time
		for (int i=0 ; i < 10000000 ; i++) {
			for (int j=0 ; j < 10000000 ; j++) {
				int k=0;
				k++;
			}
		}

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ret.getGreeting());
	}

	@RequestMapping("/")
	public ResponseEntity<String> getGreetings(){
		List<Greeting> allData = repo.findAll();
		LOG.info("Greeting: " + allData);
		String[] ret =  new String[allData.size()];

		for (int i =0 ; i < allData.size() ; i++) {
			ret[i] = allData.get(i).getLanguageCode();
		}

		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(objectMapper().writeValueAsString(ret));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}

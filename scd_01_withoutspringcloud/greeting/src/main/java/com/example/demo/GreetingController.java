package com.example.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

	@Autowired
	GreetingDao repo;
	public GreetingController() {

	}

	@RequestMapping("/{languageCode}")
	public String getGreeting(@PathVariable String languageCode){
		LOG.info("Language Code: " + languageCode);
		Greeting ret = repo.findByLanguageCode(languageCode);
		LOG.info("Greeting: " + ret);
		return ret.getGreeting();
	}

	@RequestMapping("/")
	public String getGreeting(){
		Greeting ret = repo.findByLanguageCode("");
		LOG.info("Greeting: " + ret);
		return ret.getGreeting();
	}
}

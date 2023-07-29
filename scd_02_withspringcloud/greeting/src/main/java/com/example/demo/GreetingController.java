package com.example.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
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
		try {
			TimeUnit.MILLISECONDS.sleep(20);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
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

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new Gson().toJson(ret));
	}

}

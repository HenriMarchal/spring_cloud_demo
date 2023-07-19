package com.example.demo;

import java.util.logging.Logger;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @author Ryan Baxter
 */
@RestController
public class WebController {

	private static final Logger LOG = Logger.getLogger(WebController.class.getName());

	private NameService nameService;
	private GreetingService greetingService;

	public WebController(NameService nameService, GreetingService greetingService) {
		this.nameService = nameService;
		this.greetingService = greetingService;
	}

	@RequestMapping
	public ResponseEntity<String> index(HttpServletRequest request) {
		String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).getLanguage();
		String greeting =  new StringBuilder().append(greetingService.getGreeting(locale)).
				append(" ").append(nameService.getName()).toString();
		LOG.info("Greeting: " + greeting);
		LOG.info("Locale: " + locale);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin","*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		return ResponseEntity
				.status(HttpStatus.OK)
				.headers(headers)
				.body(greeting);
	}
}

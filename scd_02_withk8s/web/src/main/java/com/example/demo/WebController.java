package com.example.demo;

import java.util.Objects;
import java.util.logging.Logger;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class WebController {

	private static final Logger LOG = Logger.getLogger(WebController.class.getName());

	private final NameService nameService;
	private final GreetingService greetingService;

	public WebController(NameService nameService, GreetingService greetingService) {
		this.nameService = nameService;
		this.greetingService = greetingService;
	}

	@RequestMapping
	public ResponseEntity<String> index(HttpServletRequest request) {
		String locale = Objects.requireNonNull(RequestContextUtils.getLocaleResolver(request)).resolveLocale(request).getLanguage();
		String greeting = greetingService.getGreeting(locale) +
				" " + nameService.getName();
		LOG.info("Greeting: " + greeting);
		LOG.info("Locale: " + locale);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(greeting);
	}
}

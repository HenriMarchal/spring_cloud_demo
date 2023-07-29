package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GreetingProperties.class)
public class GreetingApplication {

	//TODO Gérer les exceptions, les erreurs possibles un peu partout
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

}

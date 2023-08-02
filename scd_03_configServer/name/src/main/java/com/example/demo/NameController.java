package com.example.demo;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	private static final Logger LOG = Logger.getLogger(NameController.class.getName());

	@Autowired
	private NameDao repo;

	public NameController() {

	}

	@RequestMapping("/{id}")
	public ResponseEntity<String> getName(@PathVariable Integer id) {
		Optional<Name> temp = repo.findById(id);
		String name = temp.isPresent() ? temp.get().getName() : "";
		LOG.info("Name: " + name);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(name);
	}
}

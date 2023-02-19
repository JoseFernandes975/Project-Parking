package com.sergim.zuup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ProjectParkingApplication {

	@GetMapping
	public static void main(String[] args) {
		SpringApplication.run(ProjectParkingApplication.class, args);
	}

}

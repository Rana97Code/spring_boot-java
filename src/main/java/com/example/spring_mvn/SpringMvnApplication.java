package com.example.spring_mvn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@RestController
public class SpringMvnApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMvnApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Family") String name) {
		return String.format("Hello %s!", name);
	}


}

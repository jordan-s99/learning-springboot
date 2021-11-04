package com.jordan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // need this to do mapping (i think?)

public class DemoApplication {

	public static void main(String[] args) {

		// need instances of our classes? - beans
		// spring has a dependency injection framework

		SpringApplication.run(DemoApplication.class, args);
	}
}

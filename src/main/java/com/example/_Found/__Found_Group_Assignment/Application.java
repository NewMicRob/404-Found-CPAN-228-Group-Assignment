package com.example._Found.__Found_Group_Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		String profile = context.getEnvironment().getProperty("spring.profiles.active");

		System.out.println("Profile: " + (profile != null ? profile.toUpperCase() : "DEV (DEFAULT)"));
	}
}

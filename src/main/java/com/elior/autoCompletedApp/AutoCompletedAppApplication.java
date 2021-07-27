package com.elior.autoCompletedApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoCompletedAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoCompletedAppApplication.class, args);
		System.out.println("IoC Container was loaded");
	}
}

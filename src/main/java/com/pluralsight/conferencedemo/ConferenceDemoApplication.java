package com.pluralsight.conferencedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConferenceDemoApplication {

	/***
	 * Module 4: Two basic ways to put applicatoni configuration
	 * 1) External sources: command line parameters, OS environment variables, JNDI stores
	 * 2) Internal sources: Servlet parameters, property files, java configuration
	 * Internal configuration tools can also point to external sources.
	 * There is an order in which is Spring finding and setting configuration.
	 * Main rule of thumb is that external property sources override internal ones,
	 * with the some exceptions around servlet config and servlet context parameters.
	 * See springConfigOrder.jpg in screenshots.
	 * Good practise is to pick one internal sources to provide the majority of configuration
	 * and pick one external source to provider overrides.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConferenceDemoApplication.class, args);
	}

}

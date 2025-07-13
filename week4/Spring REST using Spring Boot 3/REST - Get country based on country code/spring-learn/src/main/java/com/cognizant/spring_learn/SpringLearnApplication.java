package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("SpringLearnApplication started");

		displayDate();  // Call the new method to test the dateFormat bean
	}

	public static void displayDate() {
		// Load the context from XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");


		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try {

			Date parsedDate = format.parse("31/12/2018");
			System.out.println("Parsed Date: " + parsedDate);
		} catch (ParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
		}
	}
}

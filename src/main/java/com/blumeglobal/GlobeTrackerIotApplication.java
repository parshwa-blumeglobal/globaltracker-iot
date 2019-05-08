package com.blumeglobal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.blumeglobal")
@SpringBootApplication
public class GlobeTrackerIotApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GlobeTrackerIotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
		
		System.out.println("Blume Global Global Tracker adapter running as of: " + localDateTime.format(formatter));
	}

}

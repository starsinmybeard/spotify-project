package com.starsinmybeard.SpotifySorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class SpotifySorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifySorterApplication.class, args);
	}

}

package org.example.namesdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class NamesDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamesDbApplication.class, args);
	}

}

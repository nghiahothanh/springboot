package com.example.KMA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;
@Component
@SpringBootApplication
@EntityScan(basePackages = "com.example.KMA")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

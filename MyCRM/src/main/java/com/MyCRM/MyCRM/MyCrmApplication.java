package com.MyCRM.MyCRM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.MyCRM")
@SpringBootApplication
public class MyCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCrmApplication.class, args);
	}

}

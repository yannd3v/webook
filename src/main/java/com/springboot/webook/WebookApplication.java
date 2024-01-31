package com.springboot.webook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.springboot.webook.model")
public class WebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebookApplication.class, args);
	}

}

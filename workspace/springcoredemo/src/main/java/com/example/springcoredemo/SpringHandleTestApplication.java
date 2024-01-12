package com.example.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.example.hello.common","com.example.springcoredemo"}
)
public class SpringHandleTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHandleTestApplication.class, args);
	}

}

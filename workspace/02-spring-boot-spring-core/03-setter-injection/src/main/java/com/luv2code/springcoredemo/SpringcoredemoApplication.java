package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = {"com.luv2code.springcoredemo",
//				"com.luv2code.util"}
//)

@SpringBootApplication(
		scanBasePackages = {"com.luv2code.util.common.Coach","com.luv2code.util.common.CricketCoach"}
)
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}

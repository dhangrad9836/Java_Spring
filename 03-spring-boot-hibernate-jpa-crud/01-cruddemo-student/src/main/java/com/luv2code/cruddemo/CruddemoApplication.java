package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);	}

	//command line runner is from springboot framework
	//this will execute after the beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){

		//lambda expression
		return runner -> {
			System.out.println("Hello world");
		};
	}//end of commandlinerunner


} ///end class CruddemoApplication

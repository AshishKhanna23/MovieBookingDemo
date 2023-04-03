package com.ashish.MovieBooking;

import com.ashish.MovieBooking.services.InitService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MovieBookingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingApplication.class, args);

		System.out.println("Hello Spring Boot !!!!");

	}
	@Bean
	CommandLineRunner init(InitService initService){
		return args -> {
			initService.init();
		};
	}

	//This will store the manually created object of ModelMapper as a bean in the spring container
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}

package com.bandtech.eventech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EventechRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventechRestTemplateApplication.class, args);}

}

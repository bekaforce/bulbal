package com.almaz.rassrochka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RassrochkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RassrochkaApplication.class, args);
	}

}

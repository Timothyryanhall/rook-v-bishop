package com.grandmasters.rookvbishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RookvbishopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RookvbishopApplication.class, args);
		new Game();
	}

}

package com.epam.travelagency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TravelAgencyApplication {

    @Autowired
	private Controller controller;

    @PostConstruct
	public void init() {
		controller.showData();
	}

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);
	}
}

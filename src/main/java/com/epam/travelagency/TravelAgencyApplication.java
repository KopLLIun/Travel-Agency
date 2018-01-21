package com.epam.travelagency;

import com.epam.travelagency.controler.WebController;
import com.epam.travelagency.controler.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TravelAgencyApplication {

/*    @Autowired
	private Controller controller;

    @Autowired
    private WebController webController;

    @PostConstruct
	public void init() {
		//controller.showData();
        webController.findById(1);
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);
	}
}

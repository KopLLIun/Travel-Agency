package com.epam.travelagency.controler;

import com.epam.travelagency.entity.City;
import com.epam.travelagency.service.CityServiceImpl;
import com.epam.travelagency.service.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @RequestMapping(value = "/cities")
    public String showCities() {
        StringBuilder result = new StringBuilder("<html>");

        for (City city : cityService.getAll()) {
            result.append("<div>").append(city).append("</div>");
        }

        return result + "</html>";
    }
}

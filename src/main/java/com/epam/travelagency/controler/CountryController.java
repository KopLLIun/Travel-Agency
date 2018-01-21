package com.epam.travelagency.controler;

import com.epam.travelagency.service.CityServiceImpl;
import com.epam.travelagency.service.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/countries")
public class CountryController {

    @Autowired
    private CountryServiceImpl countryService;

    @Autowired
    private CityServiceImpl cityService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCountries(Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "countries";
    }

    @RequestMapping(value = "/{countryName}")
    public String getCountry(@PathVariable("countryName") String countryName, Model model) {
        model.addAttribute("country", countryService.getCountryByName(countryName));
        //model.addAttribute("id", countryService.getCountryById(id).getId());
        //model.addAttribute("city", cityService.getCityByName(cityName));
        return "citiesByCountry";
    }

    @RequestMapping(value = "/{countryName}/{cityName}")
    public String getCountry(@PathVariable("countryName") String countryName,
                             @PathVariable("cityName") String cityName,
                             Model model) {
        model.addAttribute("country", countryService.getCountryByName(countryName));
        model.addAttribute("city", cityService.getCityByName(cityName));
        //model.addAttribute("id", countryService.getCountryById(id).getId());
        //model.addAttribute("city", cityService.getCityByName(cityName));
        return "tour-list";
    }
}

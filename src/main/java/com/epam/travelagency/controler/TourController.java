package com.epam.travelagency.controler;

import com.epam.travelagency.entity.Tour;
import com.epam.travelagency.service.CityServiceImpl;
import com.epam.travelagency.service.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/tours")
public class TourController {

    @Autowired
    private TourServiceImpl tourServiceImpl;

    @Autowired
    private CityServiceImpl cityService;

    @RequestMapping(method = RequestMethod.GET)
    public String showTours(Model model) {
        model.addAttribute("tours", tourServiceImpl.getAll());
        //model.addAttribute("city", cityService.getAll());
        return "tours";
    }

    @RequestMapping(value = "/tour-info")
    public String showHotelTour(@RequestParam("id") Long id,
                                Model model) {
        model.addAttribute("tour_info", tourServiceImpl.getTourById(id));
        //model.addAttribute("tour", new Tour());
        //model.addAttribute("city", cityService.getCityByName(cityName));
        //model.addAttribute("hotel_tour", hotelService.getAll());
        return "tour-info";
    }

/*    @RequestMapping("/tour-list")
    public String showTours(@RequestParam("cityId") Long id, Model model) {
        model.addAttribute("city", cityService.getCityById(id));
        return "tour-list";
    }*/
}

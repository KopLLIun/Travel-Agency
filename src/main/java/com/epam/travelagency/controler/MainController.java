package com.epam.travelagency.controler;

import com.epam.travelagency.entity.Comment;
import com.epam.travelagency.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CountryServiceImpl countryService;

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private DiscountServiceImpl discountService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private ContractServiceImpl contractService;

    @Autowired
    private HotelServiceImpl hotelService;

    @Autowired
    private TourServiceImpl tourServiceImpl;

    @RequestMapping(value = {"/", "index"} , method = RequestMethod.GET)
    public String showMainPage(Model model) {
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("orders", contractService.getAll());
        //model.addAttribute("tours", tourService.getAll());
        //model.addAttribute("hotels", hotelService.getAll());
        //model.addAttribute("discount", orderService.getAll());
        return "index";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String showBlog(Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentService.getAll());
        //return countryService.getAll().toString();
        return "blog";
    }
}

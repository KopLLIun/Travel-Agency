package com.epam.travelagency.controler;

import com.epam.travelagency.entity.Customer;
import com.epam.travelagency.service.CustomerService;
import com.epam.travelagency.service.SecurityService;
import com.epam.travelagency.validator.CustomerValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CustomerValidator customerValidator;

    @RequestMapping
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("customerForm", new Customer());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("customerForm") Customer customerForm, BindingResult bindingResult, Model model) {
        customerValidator.validate(customerForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        customerService.save(customerForm);

        securityService.autoLogin(customerForm.getLogin(), customerForm.getPassword());

        return "redirect:/index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

 /*   @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }*/

   /* @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }*/
}

package com.epam.travelagency.controler;

import com.epam.travelagency.entity.Customer;
import com.epam.travelagency.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @ResponseBody
    public String saveCustomer(@RequestBody Customer customer) {
        customerServiceImpl.save(customer);
        return "redirect:../";
    }
}

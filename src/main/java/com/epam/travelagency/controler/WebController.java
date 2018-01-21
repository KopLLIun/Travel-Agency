package com.epam.travelagency.controler;

import com.epam.travelagency.entity.Customer;
import com.epam.travelagency.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/save")
    public String process() {
        Customer c1 = new Customer();
        c1.setAddress("ABC");
        c1.setFirstName("A");
        c1.setLastName("L");
        customerRepository.save(c1);
        return "Done";
    }


    @RequestMapping("/findall")
    public String findAll() {
        StringBuilder result = new StringBuilder("<html>");

        for (Customer customer : customerRepository.findAll()) {
            result.append("<div>").append(customer).append("</div>");
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        //String result = "";
        //result = customerRepository.findOne(id).toString();
        return customerRepository.findOne(id).toString();
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("last_name") String lastName) {
        String result = "<html>";

        for (Customer customer : customerRepository.findByLastName(lastName)) {
            result += "<div>" + customer + "</div>";
        }

        return result + "</html>";
    }
}

package com.epam.travelagency;

import com.epam.travelagency.entity.Customer;
import com.epam.travelagency.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    @Autowired
    private CustomerRepository customerRepository;

    public void showData() {
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
    }
}

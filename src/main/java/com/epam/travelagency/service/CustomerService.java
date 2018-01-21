package com.epam.travelagency.service;

import com.epam.travelagency.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(Long id);

    Customer getCustomerByLogin(String login);

    List<Customer> getAll();

    void save(Customer customer);

    Customer findByLogin(String login);
}

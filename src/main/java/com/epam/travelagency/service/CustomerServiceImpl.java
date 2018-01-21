package com.epam.travelagency.service;

import com.epam.travelagency.entity.Customer;
import com.epam.travelagency.entity.Role;
import com.epam.travelagency.repository.CustomerRepository;
import com.epam.travelagency.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Customer customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        customer.setRoles(roles);
        customerRepository.save(customer);
    }

    @Override
    public Customer findByLogin(String login) {
        return customerRepository.findByLogin(login);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer getCustomerByLogin(String login) {
        return customerRepository.getCustomerByLogin(login);
    }

    public List<Customer> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(customerRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
}

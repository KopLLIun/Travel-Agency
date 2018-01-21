package com.epam.travelagency.repository;

import com.epam.travelagency.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findByLogin(String login);

    Customer getCustomerByLogin(String login);
}

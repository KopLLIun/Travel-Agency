package com.epam.travelagency.repository;

import com.epam.travelagency.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    Contract getContractByCustomerId(Long id);

    List<Contract> getContractByCustomerLogin(String login);
}

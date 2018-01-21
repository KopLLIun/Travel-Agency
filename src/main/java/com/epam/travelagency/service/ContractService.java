package com.epam.travelagency.service;

import com.epam.travelagency.entity.Contract;

import java.util.List;

public interface ContractService {

    Contract getContractByCustomerId(Long id);

    Contract getContractById(Long id);

    Contract save(Contract contract);

    List<Contract> getContractByCustomerLogin(String login);
}

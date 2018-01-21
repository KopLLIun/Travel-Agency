package com.epam.travelagency.service;

import com.epam.travelagency.entity.Contract;
import com.epam.travelagency.repository.ContractRepository;
import com.epam.travelagency.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.getOne(id);
    }

    @Override
    public Contract getContractByCustomerId(Long id) {
        return contractRepository.getContractByCustomerId(id);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.saveAndFlush(contract);
    }

    @Override
    public List<Contract> getContractByCustomerLogin(String login) {
        return contractRepository.getContractByCustomerLogin(login);
    }

    public List<Contract> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(contractRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
}

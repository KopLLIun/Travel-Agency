package com.epam.travelagency.service;

import com.epam.travelagency.entity.Country;
import com.epam.travelagency.entity.Customer;
import com.epam.travelagency.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public Country getCountryByName(String countryName) {
        return countryRepository.getCountryByName(countryName);
    }

    public List<Country> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(countryRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
}

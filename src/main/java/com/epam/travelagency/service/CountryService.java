package com.epam.travelagency.service;

import com.epam.travelagency.entity.Country;

import java.util.List;

public interface CountryService {

    Country getCountryById(Long id);
    Country getCountryByName(String countryName);
    List<Country> getAll();

}

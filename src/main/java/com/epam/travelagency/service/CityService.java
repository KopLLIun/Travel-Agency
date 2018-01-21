package com.epam.travelagency.service;

import com.epam.travelagency.entity.City;

import java.util.List;

public interface CityService {
    City getCityById(Long id);
    List<City> getAll();
}

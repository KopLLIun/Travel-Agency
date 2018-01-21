package com.epam.travelagency.service;

import com.epam.travelagency.entity.City;
import com.epam.travelagency.entity.Country;
import com.epam.travelagency.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    public City getCityByName(String cityName) {
        return cityRepository.getCityByName(cityName);
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.getOne(id);
    }

    public List<City> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(cityRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
}

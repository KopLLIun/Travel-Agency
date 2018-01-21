package com.epam.travelagency.repository;

import com.epam.travelagency.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    public City getCityByName(String cityName);
}

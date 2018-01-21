package com.epam.travelagency.repository;

import com.epam.travelagency.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    public Country getCountryByName(String countryName);
}

package com.epam.travelagency.repository;

import com.epam.travelagency.entity.StayPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayPlaceRepository extends JpaRepository<StayPlace, Long> {
}

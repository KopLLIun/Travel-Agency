package com.epam.travelagency.repository;

import com.epam.travelagency.entity.StayPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StayPlaceRepository extends JpaRepository<StayPlace, Long> {
}

package com.epam.travelagency.repository;

import com.epam.travelagency.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}

package com.epam.travelagency.service;

import com.epam.travelagency.entity.Tour;
import com.epam.travelagency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TourServiceImpl {

    @Autowired
    private TourRepository tourRepository;

    public Tour getTourById(Long id) {
        return tourRepository.findOne(id);
    }

    public List<Tour> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(tourRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
}

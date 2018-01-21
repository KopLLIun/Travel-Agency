package com.epam.travelagency.service;

import com.epam.travelagency.entity.Hotel;
import com.epam.travelagency.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HotelServiceImpl {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel getHotelByID(Long id) {
        return hotelRepository.findOne(id);
    }

    public List<Hotel> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(hotelRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
}

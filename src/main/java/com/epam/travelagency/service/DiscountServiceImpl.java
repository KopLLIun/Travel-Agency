package com.epam.travelagency.service;

import com.epam.travelagency.entity.Discount;
import com.epam.travelagency.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Discount getDiscountById(Long id) {
        return discountRepository.findOne(id);
    }

    @Override
    public List<Discount> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(discountRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
}

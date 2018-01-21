package com.epam.travelagency.service;

import com.epam.travelagency.entity.Discount;

import java.util.List;

public interface DiscountService {
    public Discount getDiscountById(Long id);
    public List<Discount> getAll();
}

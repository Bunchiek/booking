package com.example.booking.service;

import com.example.booking.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> findAll();
    Hotel findById(Long id);
    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel);
    void deleteById(Long id);
}

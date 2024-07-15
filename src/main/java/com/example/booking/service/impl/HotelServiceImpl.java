package com.example.booking.service.impl;

import com.example.booking.entity.Hotel;
import com.example.booking.exception.HotelNotFoundException;
import com.example.booking.repository.HotelRepository;
import com.example.booking.service.HotelService;
import com.example.booking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;


    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }

    @Override
    public Hotel findById(Long id) {
        return repository.findById(id).orElseThrow(()->
                new HotelNotFoundException(MessageFormat.format("Отель с ID {0} не найден!",id)));
    }

    @Override
    public Hotel save(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        Hotel existedHotel = findById(hotel.getId());
        BeanUtils.copyNonNullProperties(hotel, existedHotel);
        return repository.save(existedHotel);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

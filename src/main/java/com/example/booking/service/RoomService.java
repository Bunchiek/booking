package com.example.booking.service;

import com.example.booking.entity.Room;


public interface RoomService {
    Room findById(Long id);
    Room save(Room hotel);
    Room update(Room hotel);
    void deleteById(Long id);
}

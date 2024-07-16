package com.example.booking.service.impl;

import com.example.booking.repository.BookingRepository;
import com.example.booking.service.BookingService;
import com.example.booking.service.RoomService;
import com.example.booking.service.UserService;
import com.example.booking.web.model.BookingListResponse;
import com.example.booking.web.model.BookingRequest;
import com.example.booking.web.model.BookingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final RoomService roomService;


    @Override
    public BookingResponse save(BookingRequest request) {
        return null;
    }

    @Override
    public BookingListResponse findAll() {
        return null;
    }
}

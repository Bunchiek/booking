package com.example.booking.service.impl;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Room;
import com.example.booking.entity.UnavailableDates;
import com.example.booking.entity.User;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.RoomRepository;
import com.example.booking.repository.UnavailableDatesRepository;
import com.example.booking.service.BookingService;
import com.example.booking.service.RoomService;
import com.example.booking.service.UserService;
import com.example.booking.web.model.BookingListResponse;
import com.example.booking.web.model.BookingRequest;
import com.example.booking.web.model.BookingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final RoomRepository roomRepository;
    private final UnavailableDatesRepository datesRepository;



    @Override
    public BookingResponse save(BookingRequest request) {
        Booking newBooking = new Booking();
        UnavailableDates date = new UnavailableDates();
        Room existedRoom = roomRepository.findById(request.getRoomId()).orElseThrow();
        User exstedUser = userService.findById(request.getUserId());
        BookingResponse response = new BookingResponse();

        date.setCheckInDate(request.getCheckInDate());
        date.setCheckOutDate(request.getCheckOutDate());
        date.setRoomSet(Set.of(existedRoom));
        existedRoom.getDateSet().add(date);

        newBooking.setUser(exstedUser);
        newBooking.setRoom(existedRoom);
        newBooking.setCheckInDate(request.getCheckInDate());
        newBooking.setCheckOutDate(request.getCheckOutDate());
        datesRepository.save(date);
        bookingRepository.save(newBooking);
        roomRepository.save(existedRoom);

        response.setRoom(existedRoom);
        response.setUser(exstedUser);
        response.setDates(date);
        return response;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}

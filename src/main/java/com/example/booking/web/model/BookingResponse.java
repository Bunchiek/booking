package com.example.booking.web.model;

import com.example.booking.entity.Room;
import com.example.booking.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Instant arriveDate;
    private Instant departureDate;
    private Room room;
    private User user;
}

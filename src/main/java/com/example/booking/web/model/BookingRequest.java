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
public class BookingRequest {

    private Instant arriveDate;
    private Instant departureDate;
    private Long roomId;
    private Long userId;
}

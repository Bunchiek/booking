package com.example.booking.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {

    private String name;
    private String description;
    private Integer number;
    private Double price;
    private Integer capacity;
    private LocalDate unavailableFrom;
    private LocalDate unavailableTo;
}

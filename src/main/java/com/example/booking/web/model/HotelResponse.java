package com.example.booking.web.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {

    private String id;
    private String name;
    private String title;
    private String city;
    private String address;
    private Integer distanceFromCityCenter;
    private Integer rating;
    private Integer countReview;
}

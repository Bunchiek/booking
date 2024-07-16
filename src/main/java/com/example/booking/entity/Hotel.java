package com.example.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private String city;
    private String address;

    @Column(name = "distance_from_city_center")
    private Integer distanceFromCityCenter;

    private Integer rating;

    @Column(name = "count_review")
    private Integer countReview;
}

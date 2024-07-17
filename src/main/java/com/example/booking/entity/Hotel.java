package com.example.booking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "hotel")
@Getter
@Setter
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

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Room> rooms = new ArrayList<>();
}

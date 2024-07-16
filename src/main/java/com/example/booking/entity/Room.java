package com.example.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;

@Entity
@Getter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer number;

    private Double price;

    private Integer capacity;

    @Column(name = "data_unavailable_from")
    private Instant unavailableFrom;

    @Column(name = "data_unavailable_to")
    private Instant unavailableTo;

}

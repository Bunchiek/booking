package com.example.booking.web.controller;

import com.example.booking.entity.Hotel;
import com.example.booking.mapper.HotelMapper;
import com.example.booking.service.HotelService;
import com.example.booking.web.model.HotelListResponse;
import com.example.booking.web.model.HotelRequest;
import com.example.booking.web.model.HotelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @GetMapping
    public ResponseEntity<HotelListResponse> findAll() {
        return ResponseEntity.ok(hotelMapper.hotelListToListResponse(hotelService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> findById(@PathVariable long id) {
        return ResponseEntity.ok(hotelMapper.hotelToResponse(hotelService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<HotelResponse> create(@RequestBody HotelRequest request) {
        Hotel newHotel = hotelService.save(hotelMapper.requestToHotel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelMapper.hotelToResponse(newHotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponse> update(@PathVariable("id") Long hotelId, @RequestBody HotelRequest request) {
        Hotel updatedHotel = hotelService.update(hotelMapper.requestToHotel(hotelId, request));
        return ResponseEntity.ok(hotelMapper.hotelToResponse(updatedHotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hotelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.booking.web.controller;

import com.example.booking.entity.Room;
import com.example.booking.mapper.RoomMapper;
import com.example.booking.service.RoomService;
import com.example.booking.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;


    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> findById(@PathVariable long id) {
        return ResponseEntity.ok(roomMapper.roomToResponse(roomService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<RoomResponse> create(@RequestBody RoomRequest request) {
        Room newRoom = roomService.save(roomMapper.requestToRoom(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(roomMapper.roomToResponse(newRoom));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> update(@PathVariable("id") Long roomId, @RequestBody RoomRequest request) {
        Room updatedRoom = roomService.update(roomMapper.requestToRoom(roomId, request));
        return ResponseEntity.ok(roomMapper.roomToResponse(updatedRoom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

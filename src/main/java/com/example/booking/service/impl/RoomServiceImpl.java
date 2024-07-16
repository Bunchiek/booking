package com.example.booking.service.impl;

import com.example.booking.entity.Room;
import com.example.booking.exception.EntityNotFoundException;
import com.example.booking.repository.RoomRepository;
import com.example.booking.service.RoomService;
import com.example.booking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;

    @Override
    public Room findById(Long id) {
        return repository.findById(id).orElseThrow(()->
                new EntityNotFoundException(MessageFormat.format("Комната с ID {0} не найдена!",id)));
    }

    @Override
    public Room save(Room room) {
        return repository.save(room);
    }

    @Override
    public Room update(Room room) {
        Room existedRoom = findById(room.getId());
        BeanUtils.copyNonNullProperties(room, existedRoom);
        return repository.save(existedRoom);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

package com.example.booking.web.controller;

import com.example.booking.entity.User;
import com.example.booking.exception.AlreadyExistsException;
import com.example.booking.mapper.UserMapper;
import com.example.booking.repository.UserRepository;
import com.example.booking.service.UserService;
import com.example.booking.web.model.UserListResponse;
import com.example.booking.web.model.UserRequest;
import com.example.booking.web.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll() {
        return ResponseEntity.ok(userMapper.userListToListResponse(userService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable long id) {
        return ResponseEntity.ok(userMapper.userToResponse(userService.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AlreadyExistsException("User already exists!");
        }
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsException("Email already exists!");
        }
       User newUser = userService.save(userMapper.requestToUser(request));
       return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userToResponse(newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long userId, @RequestBody UserRequest request) {
        User updatedUser = userService.update(userMapper.requestToUser(userId,request));
        return ResponseEntity.ok(userMapper.userToResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

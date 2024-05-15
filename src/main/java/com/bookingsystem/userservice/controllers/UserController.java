package com.bookingsystem.userservice.controllers;
import com.bookingsystem.userservice.dto.UserDto;
import com.bookingsystem.userservice.entities.User;
import com.bookingsystem.userservice.services.UserService.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private IUserService userService;

    @GetMapping
    public ResponseEntity< List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> registerCustomerAccount(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.registerCustomerAccount(userDto));
    }
}

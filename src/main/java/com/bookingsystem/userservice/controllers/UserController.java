package com.bookingsystem.userservice.controllers;
import com.bookingsystem.userservice.dto.UserDto;
import com.bookingsystem.userservice.entities.User;
import com.bookingsystem.userservice.services.UserService.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private IUserService userService;

    @GetMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity< List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerCustomerAccount(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.registerCustomerAccount(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id , @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id,userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}

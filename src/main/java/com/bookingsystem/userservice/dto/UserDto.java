package com.bookingsystem.userservice.dto;

import com.bookingsystem.userservice.entities.Telephone;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private Telephone telephone;
    private String password;
    private String address;
}

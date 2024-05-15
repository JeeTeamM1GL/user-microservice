package com.bookingsystem.userservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private Telephone telephone;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean enabled = false;
    private Instant createdAt;
    private Instant updatedAt;
}

package com.bookingsystem.userservice.repositories;

import com.bookingsystem.userservice.entities.Role;
import com.bookingsystem.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByRole(Role role);
}

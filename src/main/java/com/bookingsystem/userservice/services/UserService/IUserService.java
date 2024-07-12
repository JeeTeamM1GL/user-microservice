package com.bookingsystem.userservice.services.UserService;

import com.bookingsystem.userservice.dto.UserDto;
import com.bookingsystem.userservice.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Boolean registerCustomerAccount(UserDto userDto);
    List<User> findAll();
    Optional<User> findUserById(String id);
    void createSuperAdmin();
    User updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
}

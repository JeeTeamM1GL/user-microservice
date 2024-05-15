package com.bookingsystem.userservice.services.UserService;

import com.bookingsystem.userservice.core.utils.IDGenerate;
import com.bookingsystem.userservice.dto.UserDto;
import com.bookingsystem.userservice.entities.Role;
import com.bookingsystem.userservice.entities.User;
import com.bookingsystem.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createSuperAdmin() {
        User user = User.builder()
                .id(IDGenerate.generate("USR"))
                .firstName("superadmin")
                .lastName("superadmin")
                .email("superadmin@superadmin.com")
                .password(passwordEncoder.encode("Passer1234@"))
                .role(Role.SUPER_ADMIN)
                .enabled(true)
                .createdAt(Instant.now())
                .build();
        List<User> list = userRepository.findByRole(Role.SUPER_ADMIN);
        System.out.println(list);
        if (list.isEmpty()){
            userRepository.save(user);
        }else {
            System.out.println("Le super admin existe déjà");
        }

    }

    public Boolean registerCustomerAccount(UserDto userDto) {
//        User user = new User();
//        user.setId(IDGenerate.generate("USR"));
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setAddress(userDto.getAddress());
//        user.setRole(Role.CUSTOMER);
//        user.setEnabled(true);

        User user = User.builder()
                .id(IDGenerate.generate("USR"))
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .address(userDto.getAddress())
                .role(Role.CUSTOMER)
                .enabled(true)
                .build();
        User userCreated = userRepository.save(user);
        return userCreated.isEnabled();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }
}

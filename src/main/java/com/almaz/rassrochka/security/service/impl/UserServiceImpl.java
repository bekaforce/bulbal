package com.almaz.rassrochka.security.service.impl;

import com.almaz.rassrochka.enums.Status;
import com.almaz.rassrochka.security.domain.Role;
import com.almaz.rassrochka.security.domain.User;
import com.almaz.rassrochka.security.domain.repo.UserRepo;
import com.almaz.rassrochka.security.dto.UserDto;
import com.almaz.rassrochka.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleServiceImpl roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, RoleServiceImpl roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(UserDto userDto) {
        User user = userRepo.findByUsername(userDto.getName());
        if (user != null){
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        else {
            user = new User();
            user.setUsername(userDto.getName());
            Role roleUser = roleService.findByName("ROLE_USER");
//            Role role = new Role();
//            role.setName("ROLE_USER");
            List<Role> userRoles = new ArrayList<>();
            userRoles.add(roleUser);
            user.setRoles(userRoles);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setStatus(Status.ACTIVE);
        }
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDate(LocalDateTime.now());
        return userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByUsername(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}


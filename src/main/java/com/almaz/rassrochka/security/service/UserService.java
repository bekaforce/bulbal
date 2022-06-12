package com.almaz.rassrochka.security.service;

import com.almaz.rassrochka.security.domain.User;
import com.almaz.rassrochka.security.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(UserDto userDto);
    User findByUsername(String userName);

    List<User> findAllUsers();

    Optional<User> editUserName(Long id, UserDto userDto);
}


package com.almaz.bulbal.security.service;

import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(UserDto userDto);
    User findByUsername(String userName);

    List<User> findAllUsers();

    Optional<User> editUserName(Long id, UserDto userDto);

    List<Object> getAllUserName();
}


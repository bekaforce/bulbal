package com.almaz.rassrochka.security.service;

import com.almaz.rassrochka.security.domain.User;
import com.almaz.rassrochka.security.dto.UserDto;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    User register(UserDto userDto);
    User findByUsername(String userName);
}


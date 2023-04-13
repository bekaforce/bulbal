package com.almaz.bulbal.security.service;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.dto.GetUserDto;
import com.almaz.bulbal.security.dto.UserDto;
import org.springframework.data.jpa.repository.Query;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(UserDto userDto);
    User findByUsername(String userName);

    List<User> findAllUsers();

    Optional<User> editUserName(Long id, UserDto userDto);

    List<Object> getAllUserName();

    String sendSimpleMail(EmailDetails details) throws MessagingException;

    GetUserDto getUserDtoById(Long id);
}


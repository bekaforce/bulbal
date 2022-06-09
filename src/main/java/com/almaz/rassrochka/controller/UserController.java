package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.security.domain.User;
import com.almaz.rassrochka.security.dto.UserDto;
import com.almaz.rassrochka.security.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.almaz.rassrochka.endpoints.Endpoints.LOGIN;

@RestController
@CrossOrigin
@RequestMapping(value = LOGIN)
public class UserController {
    private final UserServiceImpl userService;

    public UserController( UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveGuest(@RequestBody UserDto userDto) {
        User response = userService.register(userDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try again", HttpStatus.BAD_REQUEST);
    }

}

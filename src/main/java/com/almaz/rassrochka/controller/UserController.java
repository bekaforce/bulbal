package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.security.domain.User;
import com.almaz.rassrochka.security.dto.UserDto;
import com.almaz.rassrochka.security.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.almaz.rassrochka.endpoints.Endpoints.USER;

@RestController
@CrossOrigin
@RequestMapping(value = USER)
public class UserController {
    private final UserServiceImpl userService;

    public UserController( UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveGuest(@RequestBody UserDto userDto) {
        User response = userService.register(userDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try again", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Получить список всех пользователей", notes = "Получить список всех пользователей")
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @ApiOperation(value = "Изменить логин и пароль пользователя", notes = "Изменить логин и пароль пользователя")
    @PutMapping("/editUser/{id}")
    public Optional<User> editUser(@RequestBody UserDto userDto, @PathVariable Long id){
        return userService.editUserName(id, userDto);
    }

}

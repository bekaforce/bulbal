package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.dto.FormDto;
import com.almaz.bulbal.security.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import static com.almaz.bulbal.endpoints.Endpoints.USER;

@RestController
@CrossOrigin
@RequestMapping(USER)
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PutMapping("/fillOutAForm")
    public User fillOutAForm(@RequestBody FormDto formDto){
        return userService.fillOutAForm(formDto);
    }
}

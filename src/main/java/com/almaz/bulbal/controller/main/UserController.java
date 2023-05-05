package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.model.main.Image;
import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.dto.FormDto;
import com.almaz.bulbal.security.service.impl.UserServiceImpl;
import com.almaz.bulbal.service.main.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.almaz.bulbal.endpoints.Endpoints.USER;

@RestController
@CrossOrigin
@RequestMapping(USER)
public class UserController {
    private final UserServiceImpl userService;
    private final ImageService imageService;

    public UserController(UserServiceImpl userService, ImageService imageService) {
        this.userService = userService;
        this.imageService = imageService;
    }

    @PutMapping("/fillOutAForm")
    public User fillOutAForm(@RequestBody FormDto formDto){
        return userService.fillOutAForm(formDto);
    }

    @GetMapping(value = "/findUserById/{id}")
    public User userById(@PathVariable(value = "id") Long id) {
    return userService.userById(id);
    }

    @PostMapping("/uploadAvatar/{userId}")
    public Image uploadAvatar(@RequestParam("multipartFile") MultipartFile multipartFile,
                                 @PathVariable(name = "userId") Long userId) throws IOException {
        return imageService.uploadAvatar(multipartFile, userId);

    }
}

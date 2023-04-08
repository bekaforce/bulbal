package com.almaz.bulbal.controller;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.security.dto.UserDto;
import com.almaz.bulbal.security.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

import static com.almaz.bulbal.endpoints.Endpoints.SEND_MAIL;

@RestController
@CrossOrigin
@RequestMapping(value = SEND_MAIL)
public class SendEmailController {

    private final UserServiceImpl userService;

    public SendEmailController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailDetails details) throws MessagingException {
        return userService.sendSimpleMail(details);
    }

    @PostMapping("/checkOtp")
    public ResponseEntity<?> checkOtp(@RequestBody UserDto userDto) {
        boolean response = userService.checkOtpPassword(userDto);
        return response
                ? new ResponseEntity<>("OTP correct: " + userDto.getEmail(), HttpStatus.OK)
                : new ResponseEntity<>("Not found: " + userDto.getOtp(), HttpStatus.NOT_FOUND);
    }
}

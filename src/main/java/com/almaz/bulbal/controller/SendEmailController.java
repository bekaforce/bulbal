package com.almaz.bulbal.controller;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.security.service.impl.UserServiceImpl;
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
}

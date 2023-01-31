package com.almaz.bulbal.controller;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.service.email.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class SendEmailController {

    private final EmailService emailService;

    public SendEmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) throws MessagingException {
        return emailService.sendSimpleMail(details);
    }
}

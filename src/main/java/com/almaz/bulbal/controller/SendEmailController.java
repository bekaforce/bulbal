package com.almaz.bulbal.controller;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.domain.repo.UserRepo;
import com.almaz.bulbal.security.dto.UserDto;
import com.almaz.bulbal.security.jwt.JwtTokenProvider;
import com.almaz.bulbal.security.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

import java.time.LocalDateTime;

import static com.almaz.bulbal.endpoints.Endpoints.SEND_MAIL;

@RestController
@CrossOrigin
@RequestMapping(value = SEND_MAIL)
public class SendEmailController {

    private final UserServiceImpl userService;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public SendEmailController(UserServiceImpl userService, UserRepo userRepo, BCryptPasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailDetails details) throws MessagingException {
        return userService.sendSimpleMail(details);
    }


    @PostMapping("/checkOtp")
    public ResponseEntity<?> checkOtp(@RequestBody UserDto userDto) {
        boolean response = userService.checkOtpPassword(userDto);
        return response
                ? new ResponseEntity<>(getToken(userDto), HttpStatus.OK)
                : new ResponseEntity<>("Bad OTP", HttpStatus.NOT_FOUND);
    }

private String getToken(UserDto userDto){
    String email = userDto.getEmail();
    userRepo.findById(userRepo.getIdByUserName(email))
            .map(user -> {
                user.setPassword(passwordEncoder.encode(userRepo.getPersonalPass(email)));
                user.setDate(LocalDateTime.now());
                return userRepo.save(user);
            });
    User user = userRepo.findByUsername(userDto.getEmail());
    return "token: " + jwtTokenProvider.createToken(user.getUsername(), user.getRoles(), user.getId());

}

}

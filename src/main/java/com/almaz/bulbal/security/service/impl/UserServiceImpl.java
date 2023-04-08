package com.almaz.bulbal.security.service.impl;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.enums.Status;
import com.almaz.bulbal.security.domain.Role;
import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.domain.repo.UserRepo;
import com.almaz.bulbal.security.dto.UserDto;
import com.almaz.bulbal.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleServiceImpl roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;

    public UserServiceImpl(UserRepo userRepo, RoleServiceImpl roleService,
                           BCryptPasswordEncoder passwordEncoder, JavaMailSender javaMailSender, SpringTemplateEngine springTemplateEngine) {
        this.userRepo = userRepo;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
        this.springTemplateEngine = springTemplateEngine;
    }
    String pass = String.valueOf(generateDigits());

    @Override
    public User register(UserDto userDto) {
        User user = userRepo.findByUsername(userDto.getUsername());
        if (user != null){
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        else {
            user = new User();
            user.setUsername(userDto.getUsername());
            Role roleUser = roleService.findByName("ROLE_ADMIN");
            List<Role> userRoles = new ArrayList<>();
            userRoles.add(roleUser);
            user.setRoles(userRoles);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setStatus(Status.ACTIVE);
        }
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDate(LocalDateTime.now());
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> editUserName(Long id, UserDto userDto) {
        return userRepo.findById(id)
                .map(us ->{
                    us.setPassword(passwordEncoder.encode(userDto.getPassword()));
                    us.setUsername(userDto.getUsername());
                    us.setPhoneNumber(userDto.getPhoneNumber());
                    us.setDate(LocalDateTime.now());
                    us.setAdminLogin(SecurityContextHolder
                            .getContext()
                            .getAuthentication()
                            .getName());
                    return userRepo.save(us);
                });
    }

    @Override
    public List<Object> getAllUserName() {

        return userRepo.findUserName();
    }
    @Override
    public String sendSimpleMail(EmailDetails details) {
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();

//            model.put("userName", details.getUserName());
            model.put("location", pass);
            model.put("sign", "Java Developer");
            helper.setFrom("bulbal@gmail.com");
            helper.setTo(details.getEmail());
            helper.setSubject("Registration");
            context.setVariables(model);
            String html = springTemplateEngine.process("welcome-email", context);
            helper.setText(html, true);
            register(UserDto.builder()
                    .username(details.getEmail())
                    .password(pass)
                    .otp(pass)
                    .personalPass(details.getPassword())
                    .build());

            javaMailSender.send(message);
            return "Mail Sent Successfully...";
        } catch (MessagingException e) {
            return "Error while sending mail!!!";
        }
    }
    public int generateDigits() {
        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);

    }
}


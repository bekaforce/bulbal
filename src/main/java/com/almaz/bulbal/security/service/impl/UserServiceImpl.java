package com.almaz.bulbal.security.service.impl;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.enums.Status;
import com.almaz.bulbal.security.domain.Role;
import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.domain.repo.UserRepo;
import com.almaz.bulbal.security.dto.FormDto;
import com.almaz.bulbal.security.dto.GetUserDto;
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
        User user = userRepo.findByUsername(userDto.getEmail());
        if (user != null){
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        else {
            user = new User();
            user.setUsername(userDto.getEmail());
            Role roleUser = roleService.findByName("ROLE_USER");
            List<Role> userRoles = new ArrayList<>();
            userRoles.add(roleUser);
            user.setRoles(userRoles);
            user.setOtp(userDto.getOtp());
            user.setPersonalPass(userDto.getPersonalPass());
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
                    us.setUsername(userDto.getEmail());
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

            model.put("location", "Кыргызстан");
            model.put("pass", pass);
            model.put("userName", details.getEmail().replaceAll("@.*", ""));
            model.put("sign", "Команда Bulbal");
            helper.setFrom("bulbal@gmail.com");
            helper.setTo(details.getEmail());
            helper.setSubject("Регистрация на сайтe Bulbal");
            context.setVariables(model);
            String html = springTemplateEngine.process("welcome-email", context);
            helper.setText(html, true);
            register(UserDto.builder()
                    .email(details.getEmail())
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

    @Override
    public GetUserDto getUserDtoByAccommodationId(Long id) {
        return userRepo.getUserDtoByAccommodationId(id);
    }

    @Override
    public User fillOutAForm(FormDto formDto) {
        User user = userRepo.findUserById(formDto.getUserId());
        if (user != null){
            setUser(user, formDto);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public void setUser(User user, FormDto formDto) {
        user.setName(formDto.getName());
        user.setNickName(formDto.getNickName());
        user.setDescription(formDto.getDescription());
        user.setPhoneNumber(formDto.getPhoneNumber());
        user.setContactPerson(formDto.getContactPerson());
        user.setLiveIn(formDto.getLiveIn());
        user.setInstagramUrl(formDto.getInstagramUrl());
        user.setTwitterUrl(formDto.getTwitterUrl());
        user.setHobbies(formDto.getHobbies());
        user.setLikeTravels(formDto.getTravels());
        user.setLanguage(formDto.getLanguage());
    }

    @Override
    public User userById(Long id) {
        return userRepo.findUserById(id);
    }

    public int generateDigits() {
        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);

    }

    public Boolean checkOtpPassword(UserDto userDto){
        String email = userDto.getEmail();
        if (userDto.getOtp().equals(userRepo.getOtpByEmail(email))){
            userRepo.findById(userRepo.getIdByUserName(email))
                    .map(user -> {
                        user.setPassword(passwordEncoder.encode(userRepo.getPersonalPass(email)));
                        user.setDate(LocalDateTime.now());
                        return userRepo.save(user);
                    });
            return true;
        }
        else {
            return false;
        }

    }
}


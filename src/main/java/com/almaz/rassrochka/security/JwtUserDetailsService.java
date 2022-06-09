package com.almaz.rassrochka.security;

import com.almaz.rassrochka.security.domain.User;
import com.almaz.rassrochka.security.jwt.JwtUserFactory;
import com.almaz.rassrochka.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUsername(userName);
        if (user == null){
            throw new UsernameNotFoundException("User with username: " + userName + " was not found");
        }

        return JwtUserFactory.create(user);
    }
}


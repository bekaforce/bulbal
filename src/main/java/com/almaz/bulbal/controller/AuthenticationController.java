package com.almaz.bulbal.controller;

import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.dto.AuthenticationRequestDto;
import com.almaz.bulbal.security.dto.GetUserDto;
import com.almaz.bulbal.security.jwt.JwtTokenProvider;
import com.almaz.bulbal.security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.almaz.bulbal.endpoints.Endpoints.LOGIN;

@RestController
@CrossOrigin
@RequestMapping(value = LOGIN)
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }


    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto requestDto){
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);
            if (user == null){
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }
            String token = jwtTokenProvider.createToken(username, user.getRoles(), user.getId());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @GetMapping("userDtoById/{id}")
    public GetUserDto userDtoById(@PathVariable(value = "id") Long id){
        return userService.getUserDtoById(id);
    }

}

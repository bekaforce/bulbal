package com.almaz.bulbal.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String username;
    private String phoneNumber;
    private String password;
    private String otp;

}


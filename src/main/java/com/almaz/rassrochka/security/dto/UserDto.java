package com.almaz.rassrochka.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String name;
    private String phoneNumber;
    private String password;

}


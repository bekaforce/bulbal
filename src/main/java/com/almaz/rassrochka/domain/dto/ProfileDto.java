package com.almaz.rassrochka.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ProfileDto {
    private Long id;
    private String fullName;
    private String phone;
    private String phoneSecond;
    private Boolean delete;

}

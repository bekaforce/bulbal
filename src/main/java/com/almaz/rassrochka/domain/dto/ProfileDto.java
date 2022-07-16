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
    private String passportInn;
    private String passportSeries;
    private String passportDate;
    private String passportDepartment;
    private String passportAddress;
    private String workAddress;
    private String factAddress;
    private String phone;

}

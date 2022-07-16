package com.almaz.rassrochka.domain.dto;

import com.almaz.rassrochka.enums.StatusType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MainDashProfileDto {
    private Long id;
    private String fullName;
    private String passportInn;
    private String deviceImei;
    private StatusType statusType;
    private LocalDateTime registrationDate;
    private String salesmanLogin;

}

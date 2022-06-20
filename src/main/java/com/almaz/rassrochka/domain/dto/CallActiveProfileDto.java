package com.almaz.rassrochka.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class CallActiveProfileDto {
    private Long id;
    private String fullName;
    private String phone;
    private String deviceModel;
    private String devicePrice;
    private Integer zeroPayment;
    private Double debt;
    private Integer countMonth;
    private LocalDate payDate;
    private String statusType;
    private String salesmanLogin;
    private String comment;
    private Long creditId;
    private Long mcId;
}

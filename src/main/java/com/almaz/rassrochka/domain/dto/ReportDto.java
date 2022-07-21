package com.almaz.rassrochka.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ReportDto {
    private Long id;
    private String fullName;
    private Integer debtReport;
    private LocalDateTime registrationDate;
    private String salesmanLogin;
}

package com.almaz.rassrochka.domain.dto;

import com.almaz.rassrochka.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class MonthCreditDto {
    private Long id;
    private Double debt;
    private LocalDate payDate;
    private StatusType statusType;
    private String paymentType;
    private String comment;
    private Integer debtReport;
}

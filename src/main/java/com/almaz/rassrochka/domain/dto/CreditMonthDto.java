package com.almaz.rassrochka.domain.dto;

import com.almaz.rassrochka.domain.MonthCreditDb;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CreditMonthDto {
    private Long id;
    private Integer zeroPayment;
    private Long deviceId;
    private LocalDateTime registrationDate;
    private List<MonthCreditDb> monthCreditDbList;
}

package com.almaz.rassrochka.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CreditDto {
    private Long id;
    private Integer devicePrice;
    private Integer zeroPayment;
    private LocalDateTime zeroPaymentDate;
    private Integer firstPayment;
    private Boolean firstStatus;
    private LocalDateTime firstPaymentDate;
    private Integer secondPayment;
    private Boolean secondStatus;
    private LocalDateTime secondPaymentDate;
    private Integer thirdPayment;
    private Boolean thirdStatus;
    private LocalDateTime thirdPaymentDate;
    private Double percentFirstMonth;
    private Double percentSecondMonth;
    private Double percentThirdMonth;
    private Boolean mainStatus;
    private Long deviceId;



}

package com.almaz.rassrochka.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ReportPaymentRequestDto {
    LocalDateTime start;
    LocalDateTime end;
    List<String> paymentTypeList;
    List<String> salesmanLoginList;
}

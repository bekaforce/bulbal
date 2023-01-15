package com.almaz.rassrochka.domain.repository;

import java.time.LocalDateTime;

public interface ReportMonthPaymentDto {
    Long getDeviceId();
    String getFullName();
    Integer getCountMonth();
    Integer getDebtReport();
    String getPaymentType();
    LocalDateTime getRegistrationDate();
    String getSalesmanLogin();
}

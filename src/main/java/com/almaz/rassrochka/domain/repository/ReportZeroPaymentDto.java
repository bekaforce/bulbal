package com.almaz.rassrochka.domain.repository;

import java.time.LocalDateTime;

public interface ReportZeroPaymentDto {
    Long getDeviceId();
    String getFullName();
    Long getZeroPayment();
    String getPaymentType();
    LocalDateTime getRegistrationDate();
    String getSalesmanLogin();
}

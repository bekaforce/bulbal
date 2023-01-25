package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.enums.StatusType;

import java.time.LocalDateTime;

public interface MainDashRepoDto {
    Long getProfileId();
    Long getDeviceId();
    String getFullName();
    String getProfileNumber();
    String getPhone();
    String getDeviceModel();
    Long getDevicePrice();
    Long getZeroPayment();
    String getPaymentType();
    StatusType getStatusType();
    LocalDateTime getRegistrationDate();
    String getSalesmanLogin();

}

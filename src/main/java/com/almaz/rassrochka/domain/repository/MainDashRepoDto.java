package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.enums.StatusType;

import java.time.LocalDateTime;

public interface MainDashRepoDto {
    Long getId();
    String getFullName();
    String getPassportInn();
    String getDeviceImei();
    StatusType getStatus();
    LocalDateTime getRegistrationDate();
    String getSalesmanLogin();

}

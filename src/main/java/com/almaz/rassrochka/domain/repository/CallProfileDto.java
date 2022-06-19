package com.almaz.rassrochka.domain.repository;

import java.time.LocalDate;

public interface CallProfileDto {

    Long getId();
    String getFullName();
    String getDeviceModel();
    String getDevicePrice();
    Integer getZeroPayment();
    Integer getCountMonth();
    LocalDate getPayDate();
    String getStatusType();
    String getSalesmanLogin();
    String getComment();
    Long getCreditId();
    Long getMcId();




}

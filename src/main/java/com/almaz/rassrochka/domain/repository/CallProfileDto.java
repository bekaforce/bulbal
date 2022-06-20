package com.almaz.rassrochka.domain.repository;

import java.time.LocalDate;

public interface CallProfileDto {

    Long getId();
    String getFullName();
    String getPhone();
    String getDeviceModel();
    String getDevicePrice();
    Integer getZeroPayment();
    Integer getCountMonth();

    Double getDebt();
    LocalDate getPayDate();
    String getStatusType();
    String getSalesmanLogin();
    String getComment();
    Long getCreditId();
    Long getMcId();




}

package com.almaz.rassrochka.domain.repository;

import java.time.LocalDate;

public interface CallProfileDto {

    Long getMonthId();
    Long getProfileId();
    Long getDeviceId();
    String getFullName();
    String getPhone();
    String getDeviceModel();
    String getDevicePrice();
    Integer getZeroPayment();
    Integer getDebtReport();
    String getPaymentType();
    Integer getCountMonth();
    LocalDate getPayDate();
    String getStatusType();
    String getSalesmanLogin();
    String getComment();




}

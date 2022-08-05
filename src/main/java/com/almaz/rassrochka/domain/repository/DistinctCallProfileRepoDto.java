package com.almaz.rassrochka.domain.repository;

public interface DistinctCallProfileRepoDto {
    Long getId();
    Long getCreditId();
    String getFullName();
    String getPhone();
    String getDeviceModel();
    Integer getDevicePrice();
    Integer getZeroPayment();
    String getSalesmanLogin();

}

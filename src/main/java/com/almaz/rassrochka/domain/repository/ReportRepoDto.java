package com.almaz.rassrochka.domain.repository;

import java.time.LocalDateTime;

public interface ReportRepoDto {
    Long getId();
    String getFullName();
    Integer getDebtReport();
    LocalDateTime getRegistrationDate();
    String getSalesmanLogin();

}

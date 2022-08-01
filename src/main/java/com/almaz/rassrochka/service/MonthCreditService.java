package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.MonthCreditDb;
import com.almaz.rassrochka.domain.dto.ChangeMonthStatusDto;
import com.almaz.rassrochka.domain.dto.MonthCreditDto;
import com.almaz.rassrochka.enums.StatusType;

import java.util.List;
import java.util.Optional;

public interface MonthCreditService {
    List<MonthCreditDb> findAll();

    List<MonthCreditDb> findAllByCreditId(Long id);

    List<MonthCreditDb> getAllStatusByWait(List<StatusType> statusTypes);

    Optional<MonthCreditDb> changeStatus(ChangeMonthStatusDto changeMonthStatusDto);

    Optional<MonthCreditDb> editMonthCredit(MonthCreditDto monthCreditDto);



}

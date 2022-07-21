package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.dto.CreditBlackListDto;
import com.almaz.rassrochka.domain.dto.CreditMonthDto;

import java.util.List;
import java.util.Optional;

public interface CreditService {

    List<CreditDb> getCreditByDeviceId(Long id);

    CreditDb addMonthDto(CreditMonthDto creditMonthDto);

    CreditDb findAllById(Long id);

    Optional<CreditDb> addBlackListForCredit(CreditBlackListDto creditBlackListDto);




}

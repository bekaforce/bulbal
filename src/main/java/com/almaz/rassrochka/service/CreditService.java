package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.dto.CreditMonthDto;

import java.util.List;

public interface CreditService {

    List<CreditDb> getCreditByDeviceId(Long id);

    CreditDb addMonthDto(CreditMonthDto creditMonthDto);


}

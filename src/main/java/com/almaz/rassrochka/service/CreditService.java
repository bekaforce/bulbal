package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.dto.CreditDto;

import java.util.List;
import java.util.Optional;

public interface CreditService {
    CreditDb addCredit(CreditDto creditDto);

    List<CreditDb> getCreditByDeviceId(Long id);

    Optional<CreditDb> findCreditById(Long id);
}

package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.service.dto.CreditDto;

public interface CreditService {
    CreditDb addCredit(CreditDto creditDto);
}

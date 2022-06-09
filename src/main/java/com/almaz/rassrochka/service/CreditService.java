package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.dto.CreditDto;

public interface CreditService {
    CreditDb addCredit(CreditDto creditDto);
}

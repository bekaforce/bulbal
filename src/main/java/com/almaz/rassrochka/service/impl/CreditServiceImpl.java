package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.repository.CreditDbRepo;
import com.almaz.rassrochka.service.CreditService;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {
    private final CreditDbRepo creditDbRepo;

    public CreditServiceImpl(CreditDbRepo creditDbRepo) {
        this.creditDbRepo = creditDbRepo;
    }

    @Override
    public CreditDb addCredit(CreditDb creditDb) {
        return creditDbRepo.save(creditDb);
    }
}

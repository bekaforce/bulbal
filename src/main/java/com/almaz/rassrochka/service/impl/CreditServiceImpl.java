package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.repository.CreditDbRepo;
import com.almaz.rassrochka.service.CreditService;
import com.almaz.rassrochka.domain.dto.CreditDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreditServiceImpl implements CreditService {
    private final CreditDbRepo creditDbRepo;

    public CreditServiceImpl(CreditDbRepo creditDbRepo) {
        this.creditDbRepo = creditDbRepo;
    }

    @Override
    public CreditDb addCredit(CreditDto creditDto) {

        CreditDb creditDb = new CreditDb();
        creditDb.setDevicePrice(creditDto.getDevicePrice());
        creditDb.setZeroPayment(creditDto.getZeroPayment());
        creditDb.setZeroPaymentDate(creditDto.getZeroPaymentDate());
        creditDb.setFirstPayment(creditDto.getFirstPayment());
        creditDb.setFirstPaymentDate(creditDto.getFirstPaymentDate());
        creditDb.setFirstStatus(creditDto.getFirstStatus());
        creditDb.setSecondPayment(creditDto.getSecondPayment());
        creditDb.setSecondPaymentDate(creditDto.getSecondPaymentDate());
        creditDb.setSecondStatus(creditDto.getSecondStatus());
        creditDb.setThirdPayment(creditDto.getThirdPayment());
        creditDb.setThirdPaymentDate(creditDto.getThirdPaymentDate());
        creditDb.setThirdStatus(creditDto.getThirdStatus());
        creditDb.setPercentFirstMonth(creditDto.getPercentFirstMonth());
        creditDb.setPercentSecondMonth(creditDto.getPercentSecondMonth());
        creditDb.setPercentThirdMonth(creditDb.getPercentThirdMonth());
        creditDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        creditDb.setRegistrationDate(LocalDateTime.now());
        return creditDbRepo.save(creditDb);
    }
}

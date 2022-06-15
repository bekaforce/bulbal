package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.MonthCreditDb;
import com.almaz.rassrochka.domain.repository.MonthCreditDbRepo;
import com.almaz.rassrochka.service.MonthCreditService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthCreditServiceImpl implements MonthCreditService {
    private final MonthCreditDbRepo monthCreditDbRepo;

    public MonthCreditServiceImpl(MonthCreditDbRepo monthCreditDbRepo) {
        this.monthCreditDbRepo = monthCreditDbRepo;
    }

    @Override
    public List<MonthCreditDb> findAll() {
        return monthCreditDbRepo.findAll();
    }

    @Override
    public MonthCreditDb findAllByCreditId(Long id) {
        return monthCreditDbRepo.findAllByCreditId(id);
    }

}

package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.ReportingDb;
import com.almaz.rassrochka.domain.dto.CreditBlackListDto;
import com.almaz.rassrochka.domain.dto.CreditMonthDto;
import com.almaz.rassrochka.domain.repository.CreditDbRepo;
import com.almaz.rassrochka.domain.repository.MonthCreditDbRepo;
import com.almaz.rassrochka.domain.repository.ReportingDbRepo;
import com.almaz.rassrochka.enums.StatusType;
import com.almaz.rassrochka.service.CreditService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CreditServiceImpl implements CreditService {
    private final CreditDbRepo creditDbRepo;
    private final MonthCreditDbRepo monthCreditDbRepo;
    private final ReportingDbRepo reportingDbRepo;

    public CreditServiceImpl(CreditDbRepo creditDbRepo, MonthCreditDbRepo monthCreditDbRepo, ReportingDbRepo reportingDbRepo) {
        this.creditDbRepo = creditDbRepo;
        this.monthCreditDbRepo = monthCreditDbRepo;
        this.reportingDbRepo = reportingDbRepo;
    }
    @Override
    public List<CreditDb> getCreditByDeviceId(Long id) {
        return creditDbRepo.findAllByDeviceId(id);
    }
    @Override
    public CreditDb addMonthDto(CreditMonthDto creditMonthDto) {
//// add reporting fixme
//        ReportingDb reporting = new ReportingDb();
////        reporting.setCreditId(creditMonthDto.getId());
//        reporting.setCreditId(creditDbRepo.findByDeviceId(creditMonthDto.getDeviceId()));
//        if (creditMonthDto.getZeroPayment()!=null) {
//            reporting.setDebtReport(creditMonthDto.getZeroPayment());
//        }
//        else {
//            reporting.setDebtReport(null);
//        }
//        reporting.setRegistrationDate(LocalDateTime.now());
//        reporting.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
//        reportingDbRepo.save(reporting);
//
//  //
        CreditDb creditDb = new CreditDb();
        creditDb.setMonthCreditDb(creditMonthDto.getMonthCreditDbList());
        creditDb.setZeroPayment(creditMonthDto.getZeroPayment());
        creditDb.setStatusType(StatusType.WAIT);
        creditDb.setDeviceId(creditMonthDto.getDeviceId());
        creditDb.setRegistrationDate(creditMonthDto.getRegistrationDate());
        creditDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return creditDbRepo.save(creditDb);


    }
    @Override
    public CreditDb findAllById(Long id) {
        return creditDbRepo.findAllById(id);
    }

    @Override
    public Optional<CreditDb> addBlackListForCredit(CreditBlackListDto creditBlackListDto) {
        return creditDbRepo.findById(creditBlackListDto.getId())
                .map(list->{
                    list.setStatusType(creditBlackListDto.getStatusType());
                    list.setComments(creditBlackListDto.getComments());
                    return creditDbRepo.save(list);
                });
    }


}

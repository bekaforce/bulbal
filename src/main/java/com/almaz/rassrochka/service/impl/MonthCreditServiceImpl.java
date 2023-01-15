package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.MonthCreditDb;
import com.almaz.rassrochka.domain.ReportingDb;
import com.almaz.rassrochka.domain.dto.ChangeMonthStatusDto;
import com.almaz.rassrochka.domain.dto.MonthCreditDto;
import com.almaz.rassrochka.domain.repository.MonthCreditDbRepo;
import com.almaz.rassrochka.domain.repository.ReportingDbRepo;
import com.almaz.rassrochka.enums.StatusType;
import com.almaz.rassrochka.service.MonthCreditService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MonthCreditServiceImpl implements MonthCreditService {
    private final MonthCreditDbRepo monthCreditDbRepo;
    private final ReportingDbRepo reportingDbRepo;

    public MonthCreditServiceImpl(MonthCreditDbRepo monthCreditDbRepo, ReportingDbRepo reportingDbRepo) {
        this.monthCreditDbRepo = monthCreditDbRepo;
        this.reportingDbRepo = reportingDbRepo;
    }

    @Override
    public List<MonthCreditDb> findAll() {
        return monthCreditDbRepo.findAll();
    }

    @Override
    public List<MonthCreditDb> findAllByCreditId(Long id) {
        return monthCreditDbRepo.findAllByDeviceId(id);
    }

    @Override
    public List<MonthCreditDb> getAllStatusByWait(List<StatusType> statusTypes) {
        return monthCreditDbRepo.findAllByStatusType(StatusType.WAIT);
    }

    @Override
    public Optional<MonthCreditDb> changeStatus(ChangeMonthStatusDto changeMonthStatusDto) {
        return monthCreditDbRepo.findById(changeMonthStatusDto.getId())
                .map(list -> {
                    list.setId(changeMonthStatusDto.getId());
                    list.setStatusType(changeMonthStatusDto.getStatusType());
                    return monthCreditDbRepo.save(list);
                });
    }

    @Override
    public Optional<MonthCreditDb> editMonthCredit(MonthCreditDto monthCreditDto) {

            ReportingDb reporting = new ReportingDb();
            reporting.setDeviceId(monthCreditDbRepo.getReferenceById(monthCreditDto.getId()).getDeviceId());
            reporting.setCountMonth(monthCreditDbRepo.getReferenceById(monthCreditDto.getId()).getCountMonth());
            reporting.setPaymentType(monthCreditDbRepo.getReferenceById(monthCreditDto.getId()).getPaymentType());
            if (monthCreditDto.getDebtReport()!=null) {
                reporting.setDebtReport(monthCreditDto.getDebtReport());
            }
            else {
                reporting.setDebtReport(null);
            }
            reporting.setRegistrationDate(LocalDateTime.now());
            reporting.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
            reportingDbRepo.save(reporting);



        return monthCreditDbRepo.findById(monthCreditDto.getId())
                .map(list -> {
                    list.setId(monthCreditDto.getId());
                    list.setStatusType(monthCreditDto.getStatusType());
                    list.setDebt(monthCreditDto.getDebt());
                    list.setPayDate(monthCreditDto.getPayDate());
                    list.setComment(monthCreditDto.getComment());
                    list.setPaymentType(monthCreditDto.getPaymentType());
                    if (monthCreditDbRepo.getReferenceById(monthCreditDto.getId()).getDebtReport() == null) {
                        list.setDebtReport(monthCreditDto.getDebtReport());
                    } else {
                        list.setDebtReport(monthCreditDbRepo.getReferenceById(monthCreditDto.getId()).getDebtReport() + monthCreditDto.getDebtReport());
                    }

                    list.setRegistrationDate(LocalDateTime.now());
                    list.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
                    return monthCreditDbRepo.save(list);
                });
    }
}

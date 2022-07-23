package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.dto.ReportDto;
import com.almaz.rassrochka.domain.repository.ReportRepoDto;
import com.almaz.rassrochka.domain.repository.ReportingDbRepo;
import com.almaz.rassrochka.service.ReportingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {
    private final ReportingDbRepo reportingDbRepo;

    public ReportingServiceImpl(ReportingDbRepo reportingDbRepo) {
        this.reportingDbRepo = reportingDbRepo;
    }

    @Override
    public List<ReportDto> getAllReportByDate(LocalDateTime start, LocalDateTime end) {
        List<ReportRepoDto> dtos = reportingDbRepo.findAllReportByDate(start, end);
        return getReportDtos(dtos);
    }

    @Override
    public List<ReportDto> getAllReportByDateAndUserName(LocalDateTime start, LocalDateTime end, String username) {
        List<ReportRepoDto> dtos = reportingDbRepo.findAllReportByDateAndUserName(start, end, username);
        return getReportDtos(dtos);
    }

    private List<ReportDto> getReportDtos(List<ReportRepoDto> dtos) {
        List<ReportDto> reportDtos = new ArrayList<>();
        for (ReportRepoDto d : dtos){
            reportDtos.add(ReportDto.builder()
                    .debtReport(d.getDebtReport())
                    .fullName(d.getFullName())
                    .registrationDate(d.getRegistrationDate())
                    .salesmanLogin(d.getSalesmanLogin())
                    .id(d.getId())
                    .build());
        }
        return reportDtos;
    }
}

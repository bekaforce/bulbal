package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.dto.ReportDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportingService {
    List<ReportDto> getAllReportByDate(LocalDateTime start, LocalDateTime end);

    List<ReportDto> getAllReportByDateAndUserName(LocalDateTime start, LocalDateTime end, String username);
}

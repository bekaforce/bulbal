package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.dto.ReportDto;
import com.almaz.rassrochka.service.ReportingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.almaz.rassrochka.endpoints.Endpoints.PROFILES;

@RestController
@CrossOrigin
@RequestMapping(value = PROFILES)
public class ReportingController {
    private final ReportingService reportingService;

    public ReportingController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @ApiOperation(value = "Get all reporting by date", notes = "Get all reporting by date")
    @GetMapping("/getReportingByDate/{start}/{end}")
    public List<ReportDto> getReportByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                           @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return reportingService.getAllReportByDate(start, end);
    }

    @ApiOperation(value = "Get all reporting by date and userName", notes = "Get all reporting by date and UserName")
    @GetMapping("/getReportingByDateAndUserName/{start}/{end}/{username}")
    public List<ReportDto> getReportByDateAndUserName(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                      @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
                                                      @PathVariable String username) {
        return reportingService.getAllReportByDateAndUserName(start, end, username);
    }
}

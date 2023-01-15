package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.dto.ReportPaymentRequestDto;
import com.almaz.rassrochka.domain.repository.ReportMonthPaymentDto;
import com.almaz.rassrochka.domain.repository.ReportZeroPaymentDto;
import com.almaz.rassrochka.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.rassrochka.endpoints.Endpoints.PROFILES;

@RestController
@CrossOrigin
@RequestMapping(value = PROFILES)
public class ReportingController {
    private final ProfileService profileService;

    public ReportingController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @ApiOperation(value = "Получить отчет по ZeroPayment за выбранный период, тип платежа и логин продавца",
            notes = "Получить отчет по ZeroPayment за выбранный период, тип платежа и логин продавца")
    @PostMapping("/zeroPaymentReport")
    public List<ReportZeroPaymentDto> zeroPaymentProfile(@RequestBody ReportPaymentRequestDto reportPaymentRequestDto) {
        return profileService.zeroPaymentProfile(reportPaymentRequestDto);
    }

    @ApiOperation(value = "Получить отчет по MonthPayment за выбранный период, тип платежа и логин продавца",
            notes = "Получить отчет по MonthPayment за выбранный период, тип платежа и логин продавца")
    @PostMapping("/monthPaymentReport")
    public List<ReportMonthPaymentDto> monthPaymentProfile (@RequestBody ReportPaymentRequestDto reportPaymentRequestDto) {
        return profileService.monthPaymentProfile(reportPaymentRequestDto);
    }
}

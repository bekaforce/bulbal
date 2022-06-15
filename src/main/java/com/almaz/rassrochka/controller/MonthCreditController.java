package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.MonthCreditDb;
import com.almaz.rassrochka.service.MonthCreditService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.almaz.rassrochka.endpoints.Endpoints.MONTH;

@RestController
@CrossOrigin
@RequestMapping(value = MONTH)
public class MonthCreditController {
    private final MonthCreditService monthCreditService;

    public MonthCreditController(MonthCreditService monthCreditService) {
        this.monthCreditService = monthCreditService;
    }

    @ApiOperation(value = "Получить весь список по кредитам", notes = "Получить список по кредита")
    @GetMapping("/findAllCredit")
    public List<MonthCreditDb> findAll(){
        return monthCreditService.findAll();
    }

}

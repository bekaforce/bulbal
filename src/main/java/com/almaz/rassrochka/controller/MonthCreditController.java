package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.MonthCreditDb;
import com.almaz.rassrochka.domain.dto.MonthCreditDto;
import com.almaz.rassrochka.service.MonthCreditService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @ApiOperation(value = "Получить кредлит по ID Device", notes = "Получить кредлит по ID Device")
    @GetMapping("/findAllByCreditId/{id}")
    public List<MonthCreditDb> findAllByCreditId(@PathVariable Long id){
        return monthCreditService.findAllByCreditId(id);
    }

    @ApiOperation(value = "Изменить кредиты по месяцам", notes = "Изменить кредиты по месяцам")
    @PutMapping("/editMontCredit")
    public Optional<MonthCreditDb> editMontCredit (@RequestBody MonthCreditDto monthCreditDto){
        return monthCreditService.editMonthCredit(monthCreditDto);
    }

}

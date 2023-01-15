package com.almaz.rassrochka.controller;


import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.domain.DeviceDb;
import com.almaz.rassrochka.domain.dto.CreditBlackListDto;
import com.almaz.rassrochka.domain.dto.CreditMonthDto;
import com.almaz.rassrochka.service.CreditService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.almaz.rassrochka.endpoints.Endpoints.CREDIT;

@RestController
@CrossOrigin
@RequestMapping(value = CREDIT)
public class CreditController  {
    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @ApiOperation(value = "Поиск кредита по Device ID", notes = "Поиск кредита по Device ID")
    @GetMapping("/findCreditByDeviceId/{id}")
    public List<CreditDb> findCreditByDeviceId (@PathVariable Long id) {
        return creditService.getCreditByDeviceId(id);
    }

    @ApiOperation(value = "Поиск кредита по ID", notes = "Поиск кредита по Device ID")
    @GetMapping("/findAllById/{id}")
    public CreditDb findAllById (@PathVariable Long id) {
        return creditService.findAllById(id);
    }

    @ApiOperation(value = "Добавить кредит с месяцами", notes = "Добавить кредит с месяцами")
    @PostMapping("/addCredit")
    public CreditDb addCredit(@RequestBody CreditMonthDto creditMonthDto){
        return creditService.addMonthDto(creditMonthDto);

    }
    @ApiOperation(value = "Add and edit black list for creditId", notes = "Add and edit black list for creditId")
    @PostMapping("/addBlackList")
    public Optional<DeviceDb> addBlackList(@RequestBody CreditBlackListDto creditBlackListDto){
        return creditService.addBlackListForCredit(creditBlackListDto);

    }

}

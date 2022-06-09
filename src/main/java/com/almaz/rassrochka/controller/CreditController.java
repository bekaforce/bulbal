package com.almaz.rassrochka.controller;


import com.almaz.rassrochka.domain.CreditDb;
import com.almaz.rassrochka.service.CreditService;
import com.almaz.rassrochka.domain.dto.CreditDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import static com.almaz.rassrochka.endpoints.Endpoints.CREDIT;

@RestController
@CrossOrigin
@RequestMapping(value = CREDIT)
public class CreditController {
    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @ApiOperation(value = "Добавить кредит и привязать к профилю", notes = "Добавить кредит и привязать к профилю")
    @PostMapping("/addCredit")
    public CreditDb addCredit(@RequestBody CreditDto creditDto){
        return creditService.addCredit(creditDto);
    }

}

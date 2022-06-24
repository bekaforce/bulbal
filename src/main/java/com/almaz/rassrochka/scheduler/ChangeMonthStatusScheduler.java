package com.almaz.rassrochka.scheduler;

import com.almaz.rassrochka.domain.dto.ChangeMonthStatusDto;
import com.almaz.rassrochka.enums.StatusType;
import com.almaz.rassrochka.service.MonthCreditService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;

@Service
public class ChangeMonthStatusScheduler {
    private final MonthCreditService monthCreditService;

    public ChangeMonthStatusScheduler(MonthCreditService monthCreditService) {
        this.monthCreditService = monthCreditService;
    }

    @Scheduled(cron = "*/120 * * * * *")
    public void monthCreditStatusWait(){
        monthCreditService.getAllStatusByWait(Collections.singletonList(StatusType.WAIT))
                .stream()
                .filter(state -> state.getPayDate().isBefore(LocalDate.now()))
                .forEach(state-> monthCreditService.changeStatus(ChangeMonthStatusDto.builder()
                                .id(state.getId())
                                .statusType(StatusType.EXPIRED)
                        .build()));
    }

}

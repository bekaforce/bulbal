package com.almaz.rassrochka.domain.dto;

import com.almaz.rassrochka.domain.MonthCreditDb;
import com.almaz.rassrochka.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class DeviceDto {
    private Long id;
    private String deviceModel;
    private String deviceMemory;
    private Integer devicePrice;
    private String deviceImei;
    private String cloudLogin;
    private String cloudPass;
    private Long profileId;
    private Integer zeroPayment;
    private String paymentType;
    private List<MonthCreditDb> monthCreditDbList;
    private StatusType statusType;


}

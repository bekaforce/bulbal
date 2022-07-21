package com.almaz.rassrochka.domain.dto;

import com.almaz.rassrochka.enums.StatusType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditBlackListDto {
    private Long id;
    private StatusType statusType;
    private String comments;
}

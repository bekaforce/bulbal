package com.almaz.rassrochka.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistinctCallProfileDto {
    private Long id;
    private Long creditId;
    private String fullName;
    private String phone;
    private String deviceModel;
    private Integer devicePrice;
    private Integer zeroPayment;
}

package com.almaz.rassrochka.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DeviceDto {
    private Long id;
    private String deviceModel;
    private String deviceMemory;
    private Integer devicePrice;
    private String deviceImei;
    private Long profileId;

}

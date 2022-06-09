package com.almaz.rassrochka.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DeviceOwnerDto {

    private Long id;
    private String deviceOwner;
    private String deviceOwnerIp;
    private Long deviceId;

}

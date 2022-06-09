package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.service.dto.DeviceOwnerDto;

public interface DeviceOwnerService {
    DeviceOwnerDb addDeviceOwner(DeviceOwnerDto deviceOwnerDto);
}

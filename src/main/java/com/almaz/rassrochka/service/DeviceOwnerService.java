package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.domain.dto.DeviceOwnerDto;

import java.util.List;

public interface DeviceOwnerService {
    DeviceOwnerDb addDeviceOwner (DeviceOwnerDto deviceOwnerDto);

    List<DeviceOwnerDb> getDeviceOwnerById(Long id);
}

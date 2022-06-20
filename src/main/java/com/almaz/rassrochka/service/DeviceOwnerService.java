package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.domain.dto.DeviceOwnerDto;

import java.util.List;
import java.util.Optional;

public interface DeviceOwnerService {
    DeviceOwnerDb addDeviceOwner (DeviceOwnerDto deviceOwnerDto);

    List<DeviceOwnerDb> getDeviceOwnerById(Long id);

    Optional<DeviceOwnerDb> editDeviceOwner (DeviceOwnerDto deviceOwnerDto);
}

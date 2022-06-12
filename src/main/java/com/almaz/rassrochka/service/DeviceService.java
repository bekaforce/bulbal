package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.DeviceDb;
import com.almaz.rassrochka.domain.dto.DeviceDto;

import java.util.List;

public interface DeviceService {
    DeviceDb addDevice(DeviceDto deviceDto);

    List<DeviceDb> findDeviceById(Long id);


}

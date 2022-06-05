package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.DeviceDb;

import java.util.List;

public interface DeviceService {
    DeviceDb addDevice(DeviceDb deviceDb);

    List<DeviceDb> findAllDevice();


}

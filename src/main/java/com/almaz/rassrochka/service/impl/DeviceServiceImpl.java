package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.DeviceDb;
import com.almaz.rassrochka.domain.repository.DeviceDbRepo;
import com.almaz.rassrochka.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceDbRepo deviceDbRepo;

    public DeviceServiceImpl(DeviceDbRepo deviceDbRepo) {
        this.deviceDbRepo = deviceDbRepo;
    }

    @Override
    public DeviceDb addDevice(DeviceDb deviceDb) {
        return deviceDbRepo.save(deviceDb);
    }

    @Override
    public List<DeviceDb> findAllDevice() {
        return deviceDbRepo.findAll();
    }
}

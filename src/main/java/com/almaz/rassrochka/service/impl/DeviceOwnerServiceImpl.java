package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.domain.repository.DeviceOwnerRepo;
import com.almaz.rassrochka.service.DeviceOwnerService;
import org.springframework.stereotype.Service;

@Service
public class DeviceOwnerServiceImpl implements DeviceOwnerService {
    private final DeviceOwnerRepo deviceOwnerRepo;

    public DeviceOwnerServiceImpl(DeviceOwnerRepo deviceOwnerRepo) {
        this.deviceOwnerRepo = deviceOwnerRepo;
    }

    @Override
    public DeviceOwnerDb addDeviceOwner(DeviceOwnerDb deviceOwnerDb) {
        return deviceOwnerRepo.save(deviceOwnerDb);
    }
}

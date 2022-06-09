package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.domain.repository.DeviceOwnerRepo;
import com.almaz.rassrochka.service.DeviceOwnerService;
import com.almaz.rassrochka.domain.dto.DeviceOwnerDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeviceOwnerServiceImpl implements DeviceOwnerService {
    private final DeviceOwnerRepo deviceOwnerRepo;

    public DeviceOwnerServiceImpl(DeviceOwnerRepo deviceOwnerRepo) {
        this.deviceOwnerRepo = deviceOwnerRepo;
    }

    @Override
    public DeviceOwnerDb addDeviceOwner(DeviceOwnerDto deviceOwnerDto) {
        DeviceOwnerDb deviceOwnerDb = new DeviceOwnerDb();
        deviceOwnerDb.setDeviceOwner(deviceOwnerDto.getDeviceOwner());
        deviceOwnerDb.setDeviceId(deviceOwnerDto.getDeviceId());
        deviceOwnerDb.setDeviceOwnerIp(deviceOwnerDto.getDeviceOwnerIp());
        deviceOwnerDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        deviceOwnerDb.setRegistrationDate(LocalDateTime.now());

        return deviceOwnerRepo.save(deviceOwnerDb);
    }
}

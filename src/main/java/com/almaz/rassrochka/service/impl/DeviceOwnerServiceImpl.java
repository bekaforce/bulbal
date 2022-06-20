package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.domain.repository.DeviceOwnerRepo;
import com.almaz.rassrochka.service.DeviceOwnerService;
import com.almaz.rassrochka.domain.dto.DeviceOwnerDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<DeviceOwnerDb> getDeviceOwnerById(Long id) {
        return deviceOwnerRepo.findAllById(Collections.singleton(id));
    }

    @Override
    public Optional<DeviceOwnerDb> editDeviceOwner(DeviceOwnerDto deviceOwnerDto) {
        return deviceOwnerRepo.findById(deviceOwnerDto.getId())
                .map(list -> {
                    list.setId(deviceOwnerDto.getId());
                    list.setDeviceOwner(deviceOwnerDto.getDeviceOwner());
                    list.setDeviceOwnerIp(deviceOwnerDto.getDeviceOwnerIp());
                    list.setRegistrationDate(LocalDateTime.now());
                    list.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
                    return deviceOwnerRepo.save(list);
                });
    }
}

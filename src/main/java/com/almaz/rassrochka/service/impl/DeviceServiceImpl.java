package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.DeviceDb;
import com.almaz.rassrochka.domain.repository.DeviceDbRepo;
import com.almaz.rassrochka.service.DeviceService;
import com.almaz.rassrochka.domain.dto.DeviceDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceDbRepo deviceDbRepo;

    public DeviceServiceImpl(DeviceDbRepo deviceDbRepo) {
        this.deviceDbRepo = deviceDbRepo;
    }


    @Override
    public DeviceDb addDevice(DeviceDto deviceDto) {
        DeviceDb deviceDb = new DeviceDb();
        deviceDb.setDeviceModel(deviceDto.getDeviceModel());
        deviceDb.setDeviceMemory(deviceDto.getDeviceMemory());
        deviceDb.setDevicePrice(deviceDto.getDevicePrice());
        deviceDb.setDeviceImei(deviceDto.getDeviceImei());
        deviceDb.setProfileId(deviceDto.getProfileId());
        deviceDb.setCloudLogin(deviceDto.getCloudLogin());
        deviceDb.setCloudPass(deviceDto.getCloudPass());
        deviceDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        deviceDb.setRegistrationDate(LocalDateTime.now());
        return deviceDbRepo.save(deviceDb);
    }

    @Override
    public List<DeviceDb> findDeviceById(Long id) {
        return deviceDbRepo.findAllByProfileId(id);
    }

    @Override
    public Optional<DeviceDb> editDevice(DeviceDto deviceDto) {
        return deviceDbRepo.findById(deviceDto.getId())
                .map(deviceDb -> {
                    deviceDb.setId(deviceDto.getId());
                    deviceDb.setDeviceModel(deviceDto.getDeviceModel());
                    deviceDb.setDeviceMemory(deviceDto.getDeviceMemory());
                    deviceDb.setDevicePrice(deviceDto.getDevicePrice());
                    deviceDb.setDeviceImei(deviceDto.getDeviceImei());
                    deviceDb.setRegistrationDate(LocalDateTime.now());
                    deviceDb.setCloudLogin(deviceDto.getCloudLogin());
                    deviceDb.setCloudPass(deviceDto.getCloudPass());
                    deviceDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
                    return deviceDbRepo.save(deviceDb);
                });
    }

    @Override
    public List<DeviceDb> getDeviceByImei(String deviceImei) {
        return deviceDbRepo.findByDeviceImeiIgnoreCaseContaining(deviceImei);
    }

}

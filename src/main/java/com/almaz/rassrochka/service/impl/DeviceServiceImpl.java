package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.DeviceDb;
import com.almaz.rassrochka.domain.repository.DeviceDbRepo;
import com.almaz.rassrochka.service.DeviceService;
import com.almaz.rassrochka.service.dto.DeviceDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        deviceDb.setSalesmanLogin("Salesman Login");
        deviceDb.setRegistrationDate(LocalDateTime.now());
        return deviceDbRepo.save(deviceDb);
    }

    @Override
    public List<DeviceDb> findAllDevice() {
        return deviceDbRepo.findAll();
    }
}

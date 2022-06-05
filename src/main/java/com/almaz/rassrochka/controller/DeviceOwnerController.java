package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.service.DeviceOwnerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import static com.almaz.rassrochka.endpoints.Endpoints.OWNER;

@CrossOrigin
@RestController
@RequestMapping(value = OWNER)
public class DeviceOwnerController {
    private final DeviceOwnerService deviceOwnerService;

    public DeviceOwnerController(DeviceOwnerService deviceOwnerService) {
        this.deviceOwnerService = deviceOwnerService;
    }

    @ApiOperation(value = "Добавить владельца девайса", notes = "Добавить владельца")
    @PostMapping("/addDeviceOwner")
    public DeviceOwnerDb addDeviceOwner(@RequestBody DeviceOwnerDb deviceOwnerDb){
        return deviceOwnerService.addDeviceOwner(deviceOwnerDb);
    }
}

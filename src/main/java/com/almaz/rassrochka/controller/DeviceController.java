package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.DeviceDb;
import com.almaz.rassrochka.service.DeviceService;
import com.almaz.rassrochka.domain.dto.DeviceDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.almaz.rassrochka.endpoints.Endpoints.DEVICE;

@RestController
@CrossOrigin
@RequestMapping(value = DEVICE)
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @ApiOperation(value = "Добавить девайс в таблицу и привязать к профилю", notes = "Добавить новый девайс")
    @PostMapping("/addDevice")
    public DeviceDb addDevice(@RequestBody DeviceDto deviceDto){
        return deviceService.addDevice(deviceDto);
    }

    @ApiOperation(value = "Получить список девайсов по profile_ID", notes = "Получить список девайсов по profile_ID")
    @GetMapping("/getDeviceByProfileID/{id}")
    public List<DeviceDb> findAllDevice(@PathVariable Long id){
        return deviceService.findDeviceById(id);
    }
    @ApiOperation(value = "Изменить Device", notes = "Изменить Device")
    @PutMapping("/editDevice")
    public Optional<DeviceDb> findAllDevice(@RequestBody DeviceDto deviceDto){
        return deviceService.editDevice(deviceDto);
    }
    @ApiOperation(value = "Find device by Device Imei", notes = "Find device by Device Imei")
    @GetMapping("/findDeviceByImei/{deviceImei}")
    public List<DeviceDb> getDeviceByDeviceImei(@PathVariable String deviceImei){
        return deviceService.getDeviceByImei(deviceImei);
    }
}

package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.DeviceDb;
import com.almaz.rassrochka.service.DeviceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public DeviceDb addDevice(@RequestBody DeviceDb deviceDb){
        return deviceService.addDevice(deviceDb);
    }

    @ApiOperation(value = "Получить список всех девайсов", notes = "Получить список всех девайсов")
    @GetMapping("/getAllDevice")
    public List<DeviceDb> findAllDevice(){
        return deviceService.findAllDevice();

    }
}

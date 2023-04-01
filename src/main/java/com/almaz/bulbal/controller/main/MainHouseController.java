package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.MainHouseDto;
import com.almaz.bulbal.model.main.MainHouse;
import com.almaz.bulbal.service.main.MainHouseService;
import org.springframework.web.bind.annotation.*;

import static com.almaz.bulbal.endpoints.Endpoints.MAIN_HOUSE;

@RestController
@RequestMapping(value = MAIN_HOUSE)
@CrossOrigin
public class MainHouseController {
    private final MainHouseService mainHouseService;

    public MainHouseController(MainHouseService mainHouseService) {
        this.mainHouseService = mainHouseService;
    }

    @PostMapping(value = "/saveMainHouse")
    public MainHouse saveMainHouse (@RequestBody MainHouseDto mainHouseDto){
        return mainHouseService.saveHouse(mainHouseDto);
    }
}
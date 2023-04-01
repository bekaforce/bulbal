package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.MainHouseDto;
import com.almaz.bulbal.model.main.MainHouse;

import java.util.List;

public interface MainHouseService {

    MainHouse saveHouse(MainHouseDto mainHouseDto);
    List<MainHouse> all();
}

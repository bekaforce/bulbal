package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.MainHouseDto;
import com.almaz.bulbal.model.main.MainHouse;

import java.util.List;
import java.util.Optional;

public interface MainHouseService {

    MainHouse saveHouse(MainHouseDto mainHouseDto);
    List<MainHouse> all();

    Optional<MainHouse> editHouse(MainHouseDto mainHouseDto);
}

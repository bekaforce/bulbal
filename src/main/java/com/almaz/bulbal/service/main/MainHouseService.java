package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.MainHouseDto;
import com.almaz.bulbal.model.main.MainHouse;

public interface MainHouseService {

    MainHouse saveHouse(MainHouseDto mainHouseDto);
}

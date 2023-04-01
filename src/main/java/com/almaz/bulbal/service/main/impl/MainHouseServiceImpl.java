package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.MainHouseDto;
import com.almaz.bulbal.model.main.MainHouse;
import com.almaz.bulbal.repository.main.MainHouseRepo;
import com.almaz.bulbal.service.main.MainHouseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MainHouseServiceImpl implements MainHouseService {
    private final MainHouseRepo mainHouseRepo;

    public MainHouseServiceImpl(MainHouseRepo mainHouseRepo) {
        this.mainHouseRepo = mainHouseRepo;
    }

    @Override
    @Transactional
    public MainHouse saveHouse(MainHouseDto mainHouseDto) {
        MainHouse mainHouse1 = new MainHouse();
        mainHouse1.setFullDescriptionOfHouse(mainHouseDto.getFullDescriptionOfHouse());
        mainHouse1.setTitleOfHouse(mainHouseDto.getTitleOfHouse());
        mainHouse1.setTypeOfHouse(mainHouseDto.getTypeOfHouse());
        mainHouse1.setOwnerId(mainHouseDto.getOwnerId());
        mainHouse1.setLocality(mainHouseDto.getLocality());
        mainHouse1.setRegion(mainHouseDto.getRegion());
        mainHouse1.setPriceForOnePlace(mainHouseDto.getPriceForOnePlace());
        mainHouse1.setTypeOfRoom(mainHouseDto.getTypeOfRoom());
        mainHouse1.setTypeOfBed(mainHouseDto.getTypeOfBed());
        mainHouse1.setConveniences(mainHouseDto.getConveniences());
        mainHouse1.setRooms(mainHouseDto.getRooms());
        return mainHouseRepo.save(mainHouse1);
    }

    @Override
    public List<MainHouse> all() {
        return mainHouseRepo.findAll();
    }
}

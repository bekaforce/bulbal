package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.MainHouseDto;
import com.almaz.bulbal.model.main.MainHouse;
import com.almaz.bulbal.repository.main.MainHouseRepo;
import com.almaz.bulbal.service.main.MainHouseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MainHouseServiceImpl implements MainHouseService {
    private final MainHouseRepo mainHouseRepo;

    public MainHouseServiceImpl(MainHouseRepo mainHouseRepo) {
        this.mainHouseRepo = mainHouseRepo;
    }

    @Override
    @Transactional
    public MainHouse saveHouse(MainHouseDto mainHouseDto) {
        MainHouse mainHouse = new MainHouse();
        getHouse(mainHouseDto, mainHouse);

        return mainHouseRepo.save(mainHouse);
    }

    @Override
    public List<MainHouse> all() {
        return mainHouseRepo.findAll();
    }

    @Override
    public Optional<MainHouse> editHouse(MainHouseDto mainHouseDto) {
        return mainHouseRepo.findById(mainHouseDto.getId())
                .map(mainHouse -> {
                    getHouse(mainHouseDto, mainHouse);
                    return mainHouseRepo.save(mainHouse);
                });
    }

    private void getHouse(MainHouseDto mainHouseDto, MainHouse mainHouse){
        mainHouse.setFullDescriptionOfHouse(mainHouseDto.getFullDescriptionOfHouse());
        mainHouse.setTitleOfHouse(mainHouseDto.getTitleOfHouse());
        mainHouse.setTypeOfHouse(mainHouseDto.getTypeOfHouse());
        mainHouse.setOwnerId(mainHouseDto.getOwnerId());
        mainHouse.setLocality(mainHouseDto.getLocality());
        mainHouse.setRegion(mainHouseDto.getRegion());
        mainHouse.setPriceForOnePlace(mainHouseDto.getPriceForOnePlace());
        mainHouse.setConveniences(mainHouseDto.getConveniences());
        mainHouse.setCreateDate(LocalDateTime.now());
        mainHouse.setRooms(mainHouseDto.getRooms());

    }

}

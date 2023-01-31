package com.almaz.bulbal.service.house.impl;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfHouse;
import com.almaz.bulbal.repository.house.TypeOfHouseRepo;
import com.almaz.bulbal.service.house.TypeOfHouseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeOfHouseServiceImpl implements TypeOfHouseService {
    private final TypeOfHouseRepo typeOfHouseRepo;

    public TypeOfHouseServiceImpl(TypeOfHouseRepo typeOfHouseRepo) {
        this.typeOfHouseRepo = typeOfHouseRepo;
    }


    @Override
    public TypeOfHouse save(GetNameDto getNameDto) {
        TypeOfHouse typeOfHouse = new TypeOfHouse();
        typeOfHouse.setName(getNameDto.getName());
        return typeOfHouseRepo.save(typeOfHouse);
    }

    @Override
    public TypeOfHouse update(GetNameDto getNameDto, Long id) {
        TypeOfHouse typeOfHouse = findById(id);
        if (typeOfHouse != null){
            typeOfHouse.setName(getNameDto.getName());
            return typeOfHouseRepo.save(typeOfHouse);
        }
        return null;
    }

    @Override
    public TypeOfHouse findById(Long id) {
        return typeOfHouseRepo.findTypeOfHouseById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        TypeOfHouse typeOfHouse = findById(id);
        if (typeOfHouse != null){
            typeOfHouseRepo.delete(typeOfHouse);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeOfHouse> all() {
        return typeOfHouseRepo.findAll();
    }
}

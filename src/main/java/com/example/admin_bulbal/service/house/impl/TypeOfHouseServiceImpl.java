package com.example.admin_bulbal.service.house.impl;

import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.house.TypeOfHouse;
import com.example.admin_bulbal.repository.house.TypeOfHouseRepo;
import com.example.admin_bulbal.service.house.TypeOfHouseService;
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
            
        }
        return null;
    }

    @Override
    public TypeOfHouse findById(Long id) {
        return typeOfHouseRepo.findTypeOfHouseById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<TypeOfHouse> all() {
        return null;
    }
}

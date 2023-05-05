package com.almaz.bulbal.service.house.impl;


import com.almaz.bulbal.dto.project.GetMapDto;
import com.almaz.bulbal.model.house.TypeOfBed;
import com.almaz.bulbal.repository.house.TypeOfBedRepo;
import com.almaz.bulbal.service.house.TypeOfBedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfBedServiceImpl implements TypeOfBedService {
    private final TypeOfBedRepo typeOfBedRepo;

    public TypeOfBedServiceImpl(TypeOfBedRepo typeOfBedRepo) {
        this.typeOfBedRepo = typeOfBedRepo;
    }

    @Override
    public TypeOfBed save(GetMapDto getMapDto) {
        TypeOfBed typeOfBed = new TypeOfBed();
        typeOfBed.setName(getMapDto.getName());
        typeOfBed.setSize(getMapDto.getSize());
        return typeOfBedRepo.save(typeOfBed);
    }

    @Override
    public TypeOfBed update(GetMapDto getMapDto, Long id) {
        TypeOfBed typeOfBed = findById(id);
        if (typeOfBed != null){
            typeOfBed.setName(getMapDto.getName());
            typeOfBed.setSize(getMapDto.getSize());
            return typeOfBedRepo.save(typeOfBed);
        }
        return null;
    }

    @Override
    public TypeOfBed findById(Long id) {
        return typeOfBedRepo.findTypeOfBedById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        TypeOfBed typeOfBed = findById(id);
        if (typeOfBed != null){
            typeOfBedRepo.delete(typeOfBed);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeOfBed> all() {
        return typeOfBedRepo.findAll();
    }
}

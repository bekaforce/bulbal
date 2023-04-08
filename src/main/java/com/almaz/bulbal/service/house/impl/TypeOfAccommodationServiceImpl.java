package com.almaz.bulbal.service.house.impl;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfAccommodation;
import com.almaz.bulbal.repository.house.TypeOfAccommodationRepo;
import com.almaz.bulbal.service.house.TypeOfAccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeOfAccommodationServiceImpl implements TypeOfAccommodationService {
    private final TypeOfAccommodationRepo typeOfAccommodationRepo;

    public TypeOfAccommodationServiceImpl(TypeOfAccommodationRepo typeOfAccommodationRepo) {
        this.typeOfAccommodationRepo = typeOfAccommodationRepo;
    }

    @Override
    public TypeOfAccommodation save(GetNameDto getNameDto) {
        TypeOfAccommodation typeOfAccommodation = new TypeOfAccommodation();
        typeOfAccommodation.setName(getNameDto.getName());
        return typeOfAccommodationRepo.save(typeOfAccommodation);
    }

    @Override
    public TypeOfAccommodation update(GetNameDto getNameDto, Long id) {
        TypeOfAccommodation typeOfAccommodation = findById(id);
        if (typeOfAccommodation != null){
            typeOfAccommodation.setName(getNameDto.getName());
            return typeOfAccommodationRepo.save(typeOfAccommodation);
        }
        return null;
    }

    @Override
    public TypeOfAccommodation findById(Long id) {
        return typeOfAccommodationRepo.findTypeOfAccommodationById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        TypeOfAccommodation typeOfAccommodation = findById(id);
        if (typeOfAccommodation != null){
            typeOfAccommodationRepo.delete(typeOfAccommodation);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeOfAccommodation> all() {
        return typeOfAccommodationRepo.findAll();
    }
}

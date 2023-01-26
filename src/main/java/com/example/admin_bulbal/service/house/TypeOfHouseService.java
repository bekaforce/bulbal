package com.example.admin_bulbal.service.house;

import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.house.TypeOfHouse;

import java.util.List;

public interface TypeOfHouseService {
    TypeOfHouse save(GetNameDto getNameDto);
    TypeOfHouse update(GetNameDto getNameDto, Long id);
    TypeOfHouse findById(Long id);
    boolean deleteById(Long id);
    List<TypeOfHouse> all();
}

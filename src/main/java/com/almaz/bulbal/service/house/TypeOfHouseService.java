package com.almaz.bulbal.service.house;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfHouse;

import java.util.List;

public interface TypeOfHouseService {
    TypeOfHouse save(GetNameDto getNameDto);
    TypeOfHouse update(GetNameDto getNameDto, Long id);
    TypeOfHouse findById(Long id);
    boolean deleteById(Long id);
    List<TypeOfHouse> all();
}

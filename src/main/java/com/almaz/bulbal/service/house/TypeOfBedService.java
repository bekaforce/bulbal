package com.almaz.bulbal.service.house;

import com.almaz.bulbal.dto.project.GetMapDto;
import com.almaz.bulbal.model.house.TypeOfBed;

import java.util.List;

public interface TypeOfBedService {
    TypeOfBed save(GetMapDto getMapDto);
    TypeOfBed update(GetMapDto getMapDto, Long id);
    TypeOfBed findById(Long id);
    boolean deleteById(Long id);
    List<TypeOfBed> all();
}

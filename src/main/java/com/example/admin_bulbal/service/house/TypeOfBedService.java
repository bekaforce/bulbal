package com.example.admin_bulbal.service.house;

import com.example.admin_bulbal.dto.project.GetMapDto;
import com.example.admin_bulbal.model.house.TypeOfBed;

import java.util.List;

public interface TypeOfBedService {
    TypeOfBed save(GetMapDto getMapDto);
    TypeOfBed update(GetMapDto getMapDto, Long id);
    TypeOfBed findById(Long id);
    boolean deleteById(Long id);
    List<TypeOfBed> all();
}

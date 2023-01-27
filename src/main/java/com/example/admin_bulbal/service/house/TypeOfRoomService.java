package com.example.admin_bulbal.service.house;

import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.house.TypeOfRoom;

import java.util.List;

public interface TypeOfRoomService {
    TypeOfRoom save(GetNameDto getNameDto);
    TypeOfRoom update(GetNameDto getNameDto, Long id);
    TypeOfRoom findById(Long id);
    boolean deleteById(Long id);
    List<TypeOfRoom> all();
}

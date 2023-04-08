package com.almaz.bulbal.service.house;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfAccommodation;

import java.util.List;

public interface TypeOfAccommodationService {
    TypeOfAccommodation save(GetNameDto getNameDto);
    TypeOfAccommodation update(GetNameDto getNameDto, Long id);
    TypeOfAccommodation findById(Long id);
    boolean deleteById(Long id);
    List<TypeOfAccommodation> all();
}

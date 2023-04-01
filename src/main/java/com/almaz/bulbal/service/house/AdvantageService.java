package com.almaz.bulbal.service.house;


import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.Advantage;

import java.util.List;

public interface AdvantageService {
    Advantage save(GetNameDto getNameDto);
    Advantage update(Long id, GetNameDto getNameDto);
    boolean delete(Long id);
    List<Advantage> all();

    Advantage advantageById(Long id);
}

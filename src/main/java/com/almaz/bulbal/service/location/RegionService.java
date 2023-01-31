package com.almaz.bulbal.service.location;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.location.Region;

import java.util.List;

public interface RegionService {
    Region save(GetNameDto getNameDto);
    Region update(GetNameDto getNameDto, Long id);
    Region findById(Long id);
    boolean deleteById(Long id);
    List<Region> all();
}

package com.example.admin_bulbal.service.location;

import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.location.Region;

import java.util.List;

public interface RegionService {
    Region save(GetNameDto getNameDto);
    Region update(GetNameDto getNameDto, Long id);
    Region findById(Long id);
    boolean deleteById(Long id);
    List<Region> all();
}

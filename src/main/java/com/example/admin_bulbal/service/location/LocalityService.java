package com.example.admin_bulbal.service.location;

import com.example.admin_bulbal.dto.location.GetLocalityDto;
import com.example.admin_bulbal.model.location.Locality;
import com.example.admin_bulbal.model.location.Region;

import java.util.List;

public interface LocalityService {
    Locality save(GetLocalityDto getLocalityDto);
    Locality update(GetLocalityDto getLocalityDto, Long id);
    Locality findById(Long id);
    boolean deleteById(Long id);
    List<Locality> allByRegionId(Long id);
    Locality setLocality(Locality locality, Region region, GetLocalityDto getLocalityDto);
}

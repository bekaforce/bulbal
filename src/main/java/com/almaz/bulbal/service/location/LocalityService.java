package com.almaz.bulbal.service.location;

import com.almaz.bulbal.dto.location.GetLocalityDto;
import com.almaz.bulbal.model.location.Locality;
import com.almaz.bulbal.model.location.Region;

import java.util.List;

public interface LocalityService {
    Locality save(GetLocalityDto getLocalityDto);
    Locality update(GetLocalityDto getLocalityDto, Long id);
    Locality findById(Long id);
    boolean deleteById(Long id);
    List<Locality> allByRegionId(Long id);
    Locality setLocality(Locality locality, Region region, GetLocalityDto getLocalityDto);
}

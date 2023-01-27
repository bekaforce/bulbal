package com.example.admin_bulbal.service.location.impl;

import com.example.admin_bulbal.dto.location.GetLocalityDto;
import com.example.admin_bulbal.model.location.Locality;
import com.example.admin_bulbal.model.location.Region;
import com.example.admin_bulbal.repository.location.LocalityRepo;
import com.example.admin_bulbal.service.location.LocalityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityServiceImpl implements LocalityService {
    private final LocalityRepo localityRepo;
    private final RegionServiceImpl regionService;

    public LocalityServiceImpl(LocalityRepo localityRepo, RegionServiceImpl regionService) {
        this.localityRepo = localityRepo;
        this.regionService = regionService;
    }

    @Override
    public Locality save(GetLocalityDto getLocalityDto) {
        Region region = regionService.findById(getLocalityDto.getRegionId());
        if (region != null){
            Locality locality = new Locality();
            return setLocality(locality, region, getLocalityDto);
        }
        return null;
    }

    @Override
    public Locality update(GetLocalityDto getLocalityDto, Long id) {
        Locality locality = findById(id);
        if (locality != null){
            Region region = regionService.findById(id);
            return setLocality(locality, region, getLocalityDto);
        }
        return null;
    }

    @Override
    public Locality setLocality(Locality locality, Region region, GetLocalityDto getLocalityDto) {
        locality.setName(getLocalityDto.getName());
        locality.setRegion(region);
        return localityRepo.save(locality);
    }

    @Override
    public Locality findById(Long id) {
        return localityRepo.findLocalityById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        Locality locality = findById(id);
        if (locality != null){
            localityRepo.delete(locality);
            return true;
        }
        return false;
    }

    @Override
    public List<Locality> allByRegionId(Long id) {
        Region region = regionService.findById(id);
        if (region != null){
            return localityRepo.findAllByRegion(region);
        }
        return null;
    }
}

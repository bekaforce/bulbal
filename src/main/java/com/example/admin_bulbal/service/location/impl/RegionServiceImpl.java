package com.example.admin_bulbal.service.location.impl;

import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.location.Region;
import com.example.admin_bulbal.repository.location.RegionRepo;
import com.example.admin_bulbal.service.location.RegionService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepo regionRepo;

    public RegionServiceImpl(RegionRepo regionRepo) {
        this.regionRepo = regionRepo;
    }

    @Override
    public Region save(GetNameDto getNameDto) {
        Region region = new Region();
        region.setName(getNameDto.getName());
        return regionRepo.save(region);
    }

    @Override
    public Region update(GetNameDto getNameDto, Long id) {
        Region region = findById(id);
        if (region != null){
            region.setName(getNameDto.getName());
            return regionRepo.save(region);
        }
        return null;
    }

    @Override
    public Region findById(Long id) {
        return regionRepo.findRegionById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        Region region = findById(id);
        if (region != null){
            regionRepo.delete(region);
            return true;
        }
        return false;
    }

    @Override
    public List<Region> all() {
        return regionRepo.findAll();
    }
}

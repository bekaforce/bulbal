package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.model.main.Residence;
import com.almaz.bulbal.repository.main.ResidenceRepo;
import com.almaz.bulbal.service.main.ResidenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenceServiceImpl implements ResidenceService {
    private final ResidenceRepo residenceRepo;

    public ResidenceServiceImpl(ResidenceRepo residenceRepo) {
        this.residenceRepo = residenceRepo;
    }


    @Override
    public Residence save(Residence residence) {
        return residenceRepo.save(residence);
    }

    @Override
    public Residence update(Residence residence) {
        Residence object = residenceById(residence.getId());
        if (object != null){
            return residenceRepo.save(residence);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Residence residence = residenceById(id);
        if (residence != null){
            residenceRepo.delete(residence);
            return true;
        }
        return false;
    }

    @Override
    public Residence residenceById(Long id) {
        return residenceRepo.findResidenceById(id);
    }

    @Override
    public List<Residence> all() {
        return residenceRepo.findAll();
    }
}

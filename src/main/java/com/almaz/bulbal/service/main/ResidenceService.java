package com.almaz.bulbal.service.main;

import com.almaz.bulbal.model.main.Residence;

import java.util.List;

public interface ResidenceService {
    Residence save(Residence residence);
    Residence update(Residence residence);
    boolean delete(Long id);
    Residence residenceById(Long id);
    List<Residence> all();
}

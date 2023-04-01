package com.almaz.bulbal.service.house.impl;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.Advantage;
import com.almaz.bulbal.repository.house.AdvantageRepo;
import com.almaz.bulbal.service.house.AdvantageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvantageServiceImpl implements AdvantageService {
    private final AdvantageRepo advantageRepo;

    public AdvantageServiceImpl(AdvantageRepo advantageRepo) {
        this.advantageRepo = advantageRepo;
    }

    @Override
    public Advantage save(GetNameDto getNameDto) {
        Advantage advantage = new Advantage(getNameDto.getName());
        return advantageRepo.save(advantage);
    }

    @Override
    public Advantage update(Long id, GetNameDto getNameDto) {
        Advantage advantage = advantageById(id);
        if (advantage != null){
            advantage.setName(getNameDto.getName());
            return advantageRepo.save(advantage);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Advantage advantage = advantageById(id);
        if (advantage != null){
            advantageRepo.delete(advantage);
            return true;
        }
        return false;
    }

    @Override
    public List<Advantage> all() {
        return advantageRepo.findAll();
    }

    @Override
    public Advantage advantageById(Long id) {
        return advantageRepo.findAdvantageById(id);
    }
}

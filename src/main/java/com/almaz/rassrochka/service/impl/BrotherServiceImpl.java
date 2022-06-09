package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.BrotherDb;
import com.almaz.rassrochka.domain.repository.BrotherDbRepo;
import com.almaz.rassrochka.service.BrotherService;
import com.almaz.rassrochka.domain.dto.BrotherDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BrotherServiceImpl implements BrotherService {
    private final BrotherDbRepo brotherDbRepo;

    public BrotherServiceImpl(BrotherDbRepo brotherDbRepo) {
        this.brotherDbRepo = brotherDbRepo;
    }

    @Override
    public BrotherDb addBrother(BrotherDb brotherDb) {
        return brotherDbRepo.save(brotherDb);
    }

    @Override
    public List<BrotherDb> findByProfileId(Long id) {
        return brotherDbRepo.findAllByProfileId(id);
    }

    @Override
    public BrotherDb addBrotherDto(BrotherDto brotherDto) {
        BrotherDb brotherDb = new BrotherDb();
        brotherDb.setFullName(brotherDto.getFullName());
        brotherDb.setBrotherType(brotherDto.getBrotherType());
        brotherDb.setPhoneNumber(brotherDto.getPhoneNumber());
        brotherDb.setAddress(brotherDto.getAddress());
        brotherDb.setProfileId(brotherDto.getProfileId());
        brotherDb.setRegistrationDate(LocalDateTime.now());
        brotherDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        return brotherDbRepo.save(brotherDb);
    }


}

package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.BrotherDb;
import com.almaz.rassrochka.domain.repository.BrotherDbRepo;
import com.almaz.rassrochka.service.BrotherService;
import com.almaz.rassrochka.domain.dto.BrotherDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BrotherServiceImpl implements BrotherService {
    private final BrotherDbRepo brotherDbRepo;

    public BrotherServiceImpl(BrotherDbRepo brotherDbRepo) {
        this.brotherDbRepo = brotherDbRepo;
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

    @Override
    public Optional<BrotherDb> editBrother(BrotherDto brotherDto) {
        return brotherDbRepo.findById(brotherDto.getId())
                .map(list -> {
                    list.setId(brotherDto.getId());
                    list.setFullName(brotherDto.getFullName());
                    list.setBrotherType(brotherDto.getBrotherType());
                    list.setPhoneNumber(brotherDto.getPhoneNumber());
                    list.setAddress(brotherDto.getAddress());
                    list.setRegistrationDate(LocalDateTime.now());
                    list.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
                    return brotherDbRepo.save(list);
                });
    }


}

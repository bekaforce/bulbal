package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.ProfileDto;
import com.almaz.rassrochka.domain.repository.ProfileDbRepo;
import com.almaz.rassrochka.service.ProfileService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileDbRepo profileDbRepo;

    public ProfileServiceImpl(ProfileDbRepo profileDbRepo) {
        this.profileDbRepo = profileDbRepo;
    }
    @Override
    public List<ProfileDb> findAll() {
        return profileDbRepo.findAll();
    }

    @Override
    public Optional<ProfileDb> findById(Long id) {
        return profileDbRepo.findById(id);
    }

    @Override
    public ProfileDb addProfiles(ProfileDto profileDto) {
        ProfileDb profileDb = new ProfileDb();
        profileDb.setFullName(profileDto.getFullName());
        profileDb.setPassportInn(profileDto.getPassportInn());
        profileDb.setPassportSeries(profileDto.getPassportSeries());
        profileDb.setPassportDate(profileDto.getPassportDate());
        profileDb.setPassportDepartment(profileDto.getPassportDepartment());
        profileDb.setPassportAddress(profileDto.getPassportAddress());
        profileDb.setWorkAddress(profileDto.getWorkAddress());
        profileDb.setFactAddress(profileDto.getFactAddress());
        profileDb.setPhone(profileDto.getPhone());
        profileDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        profileDb.setRegistrationDate(LocalDateTime.now());

        return profileDbRepo.save(profileDb);
    }
    @Override
    public List<ProfileDb> findByFullName(String fullName) {
        return profileDbRepo.findByFullNameIgnoreCaseContaining(fullName);
    }
    @Override
    public List<ProfileDb> findByPassportInn(String passportInn) {
        return profileDbRepo.findByPassportInnIgnoreCaseContaining(passportInn);
    }
}

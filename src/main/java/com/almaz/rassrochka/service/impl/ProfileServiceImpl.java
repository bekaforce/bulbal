package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.repository.ProfileDbRepo;
import com.almaz.rassrochka.service.ProfileService;
import org.springframework.stereotype.Service;

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
    public ProfileDb addProfiles(ProfileDb profileDb) {
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

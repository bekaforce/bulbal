package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.repository.ProfileDbRepo;
import com.almaz.rassrochka.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ProfileDb addProfiles(ProfileDb profileDb) {
        return profileDbRepo.save(profileDb);
    }
}

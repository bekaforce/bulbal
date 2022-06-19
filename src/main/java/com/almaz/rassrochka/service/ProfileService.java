package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.CallActiveProfileDto;
import com.almaz.rassrochka.domain.dto.ProfileDto;
import com.almaz.rassrochka.domain.repository.CallProfileDto;

import java.util.List;
import java.util.Optional;

public interface ProfileService {

    List<ProfileDb> findAll();

    Optional<ProfileDb> findById(Long id);

    ProfileDb addProfiles(ProfileDto profileDto);

    List<ProfileDb> findByFullName(String fullName);

    List<ProfileDb> findByPassportInn(String passportInn);

    List<CallActiveProfileDto> findCallProfile();
}

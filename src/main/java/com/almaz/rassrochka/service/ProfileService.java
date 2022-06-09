package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.ProfileDb;

import java.util.List;
import java.util.Optional;

public interface ProfileService {

    List<ProfileDb> findAll();

    Optional<ProfileDb> findById(Long id);

    ProfileDb addProfiles(ProfileDb profileDb);

    List<ProfileDb> findByFullName(String fullName);

    List<ProfileDb> findByPassportInn(String passportInn);
}

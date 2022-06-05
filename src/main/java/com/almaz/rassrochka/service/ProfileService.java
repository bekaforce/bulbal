package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.ProfileDb;

import java.util.List;

public interface ProfileService {

    List<ProfileDb> findAll();

    ProfileDb addProfiles(ProfileDb profileDb);
}

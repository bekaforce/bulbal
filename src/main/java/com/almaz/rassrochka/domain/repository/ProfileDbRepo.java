package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.ProfileDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileDbRepo extends JpaRepository<ProfileDb, Long> {
    List<ProfileDb> findByFullNameIgnoreCaseContaining (String fullName);

    List<ProfileDb> findByPassportInnIgnoreCaseContaining (String passportInn);
}

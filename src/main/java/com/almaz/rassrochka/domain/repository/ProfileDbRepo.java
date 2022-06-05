package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.ProfileDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDbRepo extends JpaRepository<ProfileDb, Long> {
}

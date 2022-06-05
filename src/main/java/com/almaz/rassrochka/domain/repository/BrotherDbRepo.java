package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.BrotherDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrotherDbRepo extends JpaRepository<BrotherDb, Long> {
    List<BrotherDb> findAllByProfileId(Long profileId);
}

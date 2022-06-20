package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.BrotherDb;
import com.almaz.rassrochka.domain.dto.BrotherDto;

import java.util.List;
import java.util.Optional;

public interface BrotherService {

    List<BrotherDb> findByProfileId(Long id);

    BrotherDb addBrotherDto(BrotherDto brotherDto);

    Optional<BrotherDb> editBrother(BrotherDto brotherDto);
}

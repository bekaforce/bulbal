package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.BrotherDb;
import com.almaz.rassrochka.domain.dto.BrotherDto;

import java.util.List;

public interface BrotherService {
    BrotherDb addBrother(BrotherDb brotherDb);

    List<BrotherDb> findByProfileId(Long id);

    BrotherDb addBrotherDto(BrotherDto brotherDto);
}

package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.AccommodationDto;
import com.almaz.bulbal.model.main.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    Accommodation saveAccommodation(AccommodationDto accommodationDto);
    List<Accommodation> all();

    Accommodation accommodationById(Long id);
    Optional<Accommodation> editAccommodation(AccommodationDto accommodationDto);
}

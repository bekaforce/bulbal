package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.AccommodationDto;
import com.almaz.bulbal.dto.main.CreateAccommodationDto;
import com.almaz.bulbal.dto.main.CreateRoomDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Bed;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    Accommodation saveAccommodation(CreateAccommodationDto createAccommodationDto);
    Accommodation saveRoom(CreateRoomDto createRoomDto);
    List<Accommodation> all();
    void createAccommodation(CreateAccommodationDto createAccommodationDto, Accommodation accommodation);
    Accommodation accommodationById(Long id);
    Optional<Accommodation> editAccommodation(AccommodationDto accommodationDto);
    List<Bed> getBeds(CreateRoomDto createRoomDto);
}

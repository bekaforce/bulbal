package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.AccommodationDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.repository.main.AccommodationRepo;
import com.almaz.bulbal.service.main.AccommodationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepo accommodationRepo;

    public AccommodationServiceImpl(AccommodationRepo accommodationRepo) {
        this.accommodationRepo = accommodationRepo;
    }

    @Override
    @Transactional
    public Accommodation saveAccommodation(AccommodationDto accommodationDto) {
        Accommodation accommodation = new Accommodation();
        getAccommodation(accommodationDto, accommodation);

        return accommodationRepo.save(accommodation);
    }

    @Override
    public List<Accommodation> all() {
        return accommodationRepo.findAll();
    }

    @Override
    public Optional<Accommodation> editAccommodation(AccommodationDto accommodationDto) {
        return accommodationRepo.findById(accommodationDto.getId())
                .map(accommodation -> {
                    getAccommodation(accommodationDto, accommodation);
                    return accommodationRepo.save(accommodation);
                });
    }

    private void getAccommodation(AccommodationDto accommodationDto, Accommodation accommodation){
        accommodation.setFullDescriptionOfAccommodation(accommodationDto.getFullDescriptionOfAccommodation());
        accommodation.setTitleOfAccommodation(accommodationDto.getTypeOfAccommodation());
        accommodation.setTypeOfAccommodation(accommodationDto.getTypeOfAccommodation());
        accommodation.setOwnerId(accommodationDto.getOwnerId());
        accommodation.setLocality(accommodationDto.getLocality());
        accommodation.setRegion(accommodationDto.getRegion());
        accommodation.setPrice(accommodationDto.getPrice());
        accommodation.setConveniences(accommodationDto.getConveniences());
        accommodation.setCreateDate(LocalDateTime.now());
        accommodation.setBeds(accommodationDto.getBeds());
        accommodation.setPricePerBed(accommodationDto.getPricePerBed());
    }

    @Override
    public Accommodation accommodationById(Long id) {
        return accommodationRepo.findAccommodationById(id);
    }

}

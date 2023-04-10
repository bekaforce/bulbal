package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.AccommodationDto;
import com.almaz.bulbal.dto.main.CreateAccommodationDto;
import com.almaz.bulbal.dto.main.CreateRoomDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Bed;
import com.almaz.bulbal.repository.main.AccommodationRepo;
import com.almaz.bulbal.service.main.AccommodationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public Accommodation saveAccommodation(CreateAccommodationDto createAccommodationDto) {
        Accommodation accommodation = new Accommodation();
        createAccommodation(createAccommodationDto, accommodation);
        return accommodationRepo.save(accommodation);
    }

    @Override
    public Accommodation saveRoom(CreateRoomDto createRoomDto) {
        Accommodation accommodation = accommodationById(createRoomDto.getAccommodation_id());
        if (accommodation != null){
            accommodation.setTypeOfAccommodation(createRoomDto.getTypeOfAccommodation());
            accommodation.setPrice(createRoomDto.getPrice());
            accommodation.setPricePerBed(createRoomDto.getPricePerBed());
            accommodation.setBeds(getBeds(createRoomDto));
            accommodation.setCreateDate(LocalDateTime.now());
            return accommodationRepo.save(accommodation);
        }
        return null;
    }

    @Override
    public List<Accommodation> all() {
        return accommodationRepo.findAll();
    }

    @Override
    public void createAccommodation(CreateAccommodationDto createAccommodationDto, Accommodation accommodation) {
        accommodation.setOwnerId(createAccommodationDto.getOwnerId());
        accommodation.setRegion(createAccommodationDto.getRegion());
        accommodation.setLocality(createAccommodationDto.getLocality());
        accommodation.setTitleOfAccommodation(createAccommodationDto.getTitleOfAccommodation());
        accommodation.setFullDescriptionOfAccommodation(createAccommodationDto.getFullDescriptionOfAccommodation());
        accommodation.setConveniences(createAccommodationDto.getConveniences());
    }

    @Override
    public Optional<Accommodation> editAccommodation(AccommodationDto accommodationDto) {
        return accommodationRepo.findById(accommodationDto.getId())
                .map(accommodation -> {
                    editAccommodation(accommodationDto, accommodation);
                    return accommodationRepo.save(accommodation);
                });
    }

    @Override
    public List<Bed> getBeds(CreateRoomDto createRoomDto) {
        List<Bed> beds = new ArrayList<>();
        for (int i = 0; i < createRoomDto.getAmountOfBed(); i++){
            Bed bed = new Bed(0L, createRoomDto.getTypeOfBed(), createRoomDto.getSizeOfBed());
            beds.add(bed);
        }
        return beds;
    }

    private void editAccommodation(AccommodationDto accommodationDto, Accommodation accommodation){
        accommodation.setFullDescriptionOfAccommodation(accommodationDto.getFullDescriptionOfAccommodation());
        accommodation.setTitleOfAccommodation(accommodationDto.getTitleOfAccommodation());
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

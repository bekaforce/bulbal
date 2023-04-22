package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.AccommodationDto;
import com.almaz.bulbal.dto.main.CreateAccommodationDto;
import com.almaz.bulbal.dto.main.CreateBedsDto;
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
    private final ResidenceServiceImpl residenceService;

    public AccommodationServiceImpl(AccommodationRepo accommodationRepo, ResidenceServiceImpl residenceService) {
        this.accommodationRepo = accommodationRepo;
        this.residenceService = residenceService;
    }

    @Override
    @Transactional
    public Accommodation saveAccommodation(CreateAccommodationDto createAccommodationDto) {
//        Residence residence = residenceService.residenceById(createAccommodationDto.getResidenceId());
//        if (residence != null){
            Accommodation accommodation = new Accommodation();
            createAccommodation(createAccommodationDto, accommodation);
           // accommodation.setResidence(residence);
            return accommodationRepo.save(accommodation);
//        }
//        return null;
    }

    @Override
    public Accommodation saveBeds(CreateBedsDto createRoomDto) {
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
        accommodation.setAddress(createAccommodationDto.getAddress());
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
    public List<Bed> getBeds(CreateBedsDto createRoomDto) {
        List<Bed> beds = new ArrayList<>();
        for (int i = 0; i < createRoomDto.getAmountOfBed(); i++){
            Bed bed = new Bed(0L, createRoomDto.getTypeOfBed(), createRoomDto.getSizeOfBed());
            beds.add(bed);
        }
        return beds;
    }

    private void editAccommodation(AccommodationDto accommodationDto, Accommodation accommodation){
        //Residence residence = residenceService.residenceById(accommodationDto.getResidenceId());
        //accommodation.setResidence(residence);
        accommodation.setFullDescriptionOfAccommodation(accommodationDto.getFullDescriptionOfAccommodation());
        accommodation.setTitleOfAccommodation(accommodationDto.getTitleOfAccommodation());
        accommodation.setTypeOfAccommodation(accommodationDto.getTypeOfAccommodation());
        accommodation.setOwnerId(accommodationDto.getOwnerId());
        accommodation.setLocality(accommodationDto.getLocality());
        accommodation.setRegion(accommodationDto.getRegion());
        accommodation.setAddress(accommodationDto.getAddress());
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

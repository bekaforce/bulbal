package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.PageParametersDto;
import com.almaz.bulbal.dto.main.PageSearchParametersDto;
import com.almaz.bulbal.dto.project.GetLocalDateTimeDto;
import com.almaz.bulbal.repository.main.AccommodationRepo;
import com.almaz.bulbal.repository.main.MainPageDto;
import com.almaz.bulbal.service.main.MainPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class MainPageServiceImpl implements MainPageService {
    private final AccommodationRepo accommodationRepo;

    public MainPageServiceImpl(AccommodationRepo accommodationRepo) {
        this.accommodationRepo = accommodationRepo;
    }

    @Override
    public Page<MainPageDto> getMainPage(PageParametersDto pageParametersDto) {
        PageRequest pageRequest = PageRequest.of(pageParametersDto.getPageNumber(), pageParametersDto.getPageSize(), Sort.by(pageParametersDto.getSortBy()));
        return accommodationRepo.getMainPage(pageRequest);
    }

    @Override
    public Page<MainPageDto> searchAccommodations(PageSearchParametersDto pageSearchParametersDto, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        PageRequest pageRequest = PageRequest.of(pageSearchParametersDto.getPageNumber(), pageSearchParametersDto.getPageSize(), Sort.by(pageSearchParametersDto.getSortBy()));
        return accommodationRepo.searchAccommodationsByLocality(pageRequest, checkInDateTime, checkOutDateTime, pageSearchParametersDto.getLocality(), pageSearchParametersDto.getCapacity());
    }

    @Override
    public Page<MainPageDto> searchAccommodationsByPlace(PageSearchParametersDto pageSearchParametersDto, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        PageRequest pageRequest = PageRequest.of(pageSearchParametersDto.getPageNumber(), pageSearchParametersDto.getPageSize(), Sort.by(pageSearchParametersDto.getSortBy()));
        Page<MainPageDto> result = accommodationRepo.searchAccommodationsByLocality(pageRequest, checkInDateTime, checkOutDateTime, pageSearchParametersDto.getLocality(), pageSearchParametersDto.getCapacity());
        if (result.getTotalElements() == 0){
            return accommodationRepo.searchAccommodationsByRegion(pageRequest, checkInDateTime, checkOutDateTime, pageSearchParametersDto.getLocality(), pageSearchParametersDto.getCapacity());
        }
        return result;
    }

    @Override
    public List<MainPageDto> getAdminMainPage(GetLocalDateTimeDto getLocalDateTimeDto) {
        return accommodationRepo.getAdminMainPage(getLocalDateTimeDto.getStart(), getLocalDateTimeDto.getEnd(), getLocalDateTimeDto.getType());
    }

    @Override
    public Page<MainPageDto> searchBeds(PageSearchParametersDto pageSearchParametersDto, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        PageRequest pageRequest = PageRequest.of(pageSearchParametersDto.getPageNumber(), pageSearchParametersDto.getPageSize(), Sort.by(pageSearchParametersDto.getSortBy()));
        return accommodationRepo.searchBedsByLocality(pageRequest, checkInDateTime, checkOutDateTime, pageSearchParametersDto.getLocality(), pageSearchParametersDto.getCapacity());
    }

    @Override
    public Page<MainPageDto> searchBedsByPlace(PageSearchParametersDto pageSearchParametersDto, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        PageRequest pageRequest = PageRequest.of(pageSearchParametersDto.getPageNumber(), pageSearchParametersDto.getPageSize(), Sort.by(pageSearchParametersDto.getSortBy()));
        Page<MainPageDto> result = accommodationRepo.searchBedsByLocality(pageRequest, checkInDateTime, checkOutDateTime, pageSearchParametersDto.getLocality(), pageSearchParametersDto.getCapacity());
        if (result.getTotalElements() == 0){
            return accommodationRepo.searchBedsByRegion(pageRequest, checkInDateTime, checkOutDateTime, pageSearchParametersDto.getLocality(), pageSearchParametersDto.getCapacity());
        }
        return result;
    }
}

package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.PageParametersDto;
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
    public Page<MainPageDto> searchAccommodations(PageParametersDto pageParametersDto, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        PageRequest pageRequest = PageRequest.of(pageParametersDto.getPageNumber(), pageParametersDto.getPageSize(), Sort.by(pageParametersDto.getSortBy()));
        return accommodationRepo.searchAccommodations(pageRequest, checkInDateTime, checkOutDateTime);
    }
}

package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.PageParametersDto;
import com.almaz.bulbal.dto.main.PageSearchParametersDto;
import com.almaz.bulbal.repository.main.MainPageDto;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface MainPageService {

    Page<MainPageDto> getMainPage(PageParametersDto pageParametersDto);
    Page<MainPageDto> searchAccommodations(PageSearchParametersDto pageSearchParametersDto, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime);
}

package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.PageParametersDto;
import com.almaz.bulbal.dto.main.PageSearchParametersDto;
import com.almaz.bulbal.repository.main.MainPageDto;
import com.almaz.bulbal.service.main.MainPageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.almaz.bulbal.endpoints.Endpoints.MAIN_PAGE;

@RestController
@RequestMapping(value = MAIN_PAGE)
@CrossOrigin
public class MainPageController {
    private final MainPageService mainPageService;

    public MainPageController(MainPageService mainPageService) {
        this.mainPageService = mainPageService;
    }

    @PostMapping(value = "/getMainPage")
    public Page<MainPageDto> getMainPage(@PageableDefault(sort = {"create_date"}, direction = Sort.Direction.DESC)
                                         @RequestBody PageParametersDto pageParametersDto) {
        return mainPageService.getMainPage(pageParametersDto);
    }

    @PostMapping(value = "/searchAccommodations/{checkInDateTime}/{checkOutDateTime}")
    public Page<MainPageDto> searchAccommodations (@RequestBody PageSearchParametersDto pageSearchParametersDto, @PathVariable(name = "checkInDateTime")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkInDateTime,
                                                   @PathVariable(name = "checkOutDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkOutDateTime){
        return mainPageService.searchAccommodations(pageSearchParametersDto, checkInDateTime, checkOutDateTime);
    }

    @PostMapping(value = "/searchBeds/{checkInDateTime}/{checkOutDateTime}")
    public Page<MainPageDto> searchBeds(@RequestBody PageSearchParametersDto pageSearchParametersDto, @PathVariable(name = "checkInDateTime")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkInDateTime,
                                                   @PathVariable(name = "checkOutDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkOutDateTime){
        return mainPageService.searchBeds(pageSearchParametersDto, checkInDateTime, checkOutDateTime);
    }
}

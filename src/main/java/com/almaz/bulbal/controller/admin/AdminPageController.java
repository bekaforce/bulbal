package com.almaz.bulbal.controller.admin;

import com.almaz.bulbal.dto.project.GetLocalDateTimeDto;
import com.almaz.bulbal.repository.main.MainPageDto;
import com.almaz.bulbal.service.main.AccommodationService;
import com.almaz.bulbal.service.main.MainPageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.APPROVE;

@RestController
@CrossOrigin
@RequestMapping(value = APPROVE)
public class AdminPageController {

    private final MainPageService mainPageService;
    private final AccommodationService accommodationService;

    public AdminPageController(MainPageService mainPageService, AccommodationService accommodationService) {
        this.mainPageService = mainPageService;
        this.accommodationService = accommodationService;
    }

    @PostMapping(value = "/getAdminApprovePage")
    List<MainPageDto> getAdminMainPage(@RequestBody GetLocalDateTimeDto getLocalDateTimeDto){
        return mainPageService.getAdminMainPage(getLocalDateTimeDto);
    }

    @PutMapping(value = "/approveByAccommodationId/{id}/{type}")
    public boolean approve(@PathVariable(value = "id") Long accommodationId,
                           @PathVariable(value = "type")String type){
        return accommodationService.approve(accommodationId, type);
    }
}

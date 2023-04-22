package com.almaz.bulbal.controller.admin;

import com.almaz.bulbal.dto.main.CreateBedsDto;
import com.almaz.bulbal.dto.project.GetLocalDateTimeDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.repository.main.MainPageDto;
import com.almaz.bulbal.service.main.MainPageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.APPROVE;

@RestController
@CrossOrigin
@RequestMapping(value = APPROVE)
public class AdminPageController {

    private final MainPageService mainPageService;

    public AdminPageController(MainPageService mainPageService) {
        this.mainPageService = mainPageService;
    }

    @PostMapping(value = "/getAdminApprovePage")
    List<MainPageDto> getAdminMainPage(@RequestBody GetLocalDateTimeDto getLocalDateTimeDto){
        return mainPageService.getAdminMainPage(getLocalDateTimeDto);
    }
}

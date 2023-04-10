package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.PageParametersDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.repository.main.MainPageDto;
import com.almaz.bulbal.service.main.MainPageService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Page<MainPageDto> getMainPage (@RequestBody PageParametersDto pageParametersDto){
        return mainPageService.getMainPage(pageParametersDto);
    }
}

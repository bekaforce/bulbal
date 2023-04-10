package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.PageParametersDto;
import com.almaz.bulbal.repository.main.MainPageDto;
import com.almaz.bulbal.service.main.MainPageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
}

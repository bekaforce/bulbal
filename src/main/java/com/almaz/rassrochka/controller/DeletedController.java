package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.MainDashProfileDto;
import com.almaz.rassrochka.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.rassrochka.endpoints.Endpoints.DELETED;

@RestController
@CrossOrigin
@RequestMapping(value = DELETED)
public class DeletedController {
    private final ProfileService profileService;

    public DeletedController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @ApiOperation(value = "Find all deleted profiles by Name", notes = "Find all deleted profiles by Name")
    @GetMapping("/findAllDeletedStatus/{fullName}")
    public List<MainDashProfileDto> findDeletedStatus (@PathVariable String fullName){
        return profileService.findProfileByFullNameByDeletedStatus(fullName);
    }
}

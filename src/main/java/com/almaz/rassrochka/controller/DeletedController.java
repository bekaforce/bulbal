package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.dto.MainDashProfileDto;
import com.almaz.rassrochka.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @ApiOperation(value = "Find all deleted profiles by Start and End Date", notes = "Find all deleted profiles by Start and End Date")
    @GetMapping("/findAllDeletedStatusByDate/{start}/{end}")
    public List<MainDashProfileDto> findDeletedStatusByDate (@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end){
        return profileService.findDeletedProfileByDate(start, end);
    }
}

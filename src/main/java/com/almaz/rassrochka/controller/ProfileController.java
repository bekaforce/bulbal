package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.*;
import com.almaz.rassrochka.domain.repository.CallProfileDto;
import com.almaz.rassrochka.domain.repository.MainDashRepoDto;
import com.almaz.rassrochka.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.almaz.rassrochka.endpoints.Endpoints.PROFILES;

@RestController
@CrossOrigin
@RequestMapping(value = PROFILES)
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @ApiOperation(value = "Получить пользователя по ID", notes = "Получить пользователя по ID")
    @GetMapping("/findById/{id}")
    public Optional<ProfileDb> findById(@PathVariable Long id){
        return profileService.findById(id);
    }
    @ApiOperation(value = "Удалить профиль по ID", notes = "Удалить профиль по ID")
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        profileService.deleteById(id);
    }

    @ApiOperation(value = "Добавить новый профиль в таблицу", notes = "Добавить новый профиль в таблицу")
    @PostMapping("/addProfiles")
    public ProfileDb addProfiles(@RequestBody ProfileDto profileDto){
        return profileService.addProfiles(profileDto);
    }

    @ApiOperation(value = "Изменить данные по профилю", notes = "Изменить данные по профилю")
    @PutMapping("/editProfiles")
    public Optional<ProfileDb> editProfiles(@RequestBody ProfileDto profileDto){
        return profileService.editProfiles(profileDto);
    }

    @ApiOperation(value = "Получение данных на главную таблицу", notes = "Получение данных на главную таблицу")
    @GetMapping("/getDtoForMain/{start}/{end}")
    public List<MainDashRepoDto> getDtoForMain (@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end){
        return profileService.findProfileForDash(start,end);
    }
    @ApiOperation(value = "Поиск по ФИО", notes = "Поиск по ФИО")
    @GetMapping("/getDtoForMainByFullName/{fullName}")
    public List<MainDashRepoDto> getDtoForMainByFullName (@PathVariable String fullName){
        return profileService.findProfileByFullName(fullName);
    }

    @ApiOperation(value = "Вывод EXPIRED профилей", notes = "new call profile where distinct credit_id")
    @GetMapping("/findExpiredProfile")
    public List<CallProfileDto> findCallProfile(){
        return profileService.findCallProfile();
    }

}

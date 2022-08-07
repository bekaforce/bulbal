package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.*;
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

//    @ApiOperation(value = "Получить список всех пользователей", notes = "Получить список всех пользователей")
//    @GetMapping("/findAll")
//    public List<ProfileDb> findAll(){
//        return profileService.findAll();
//    }

    @ApiOperation(value = "Получить пользователя по ID", notes = "Получить пользователя по ID")
    @GetMapping("/findById/{id}")
    public Optional<ProfileDb> findById(@PathVariable Long id){
        return profileService.findById(id);
    }

//    @ApiOperation(value = "Поиск по фамилии", notes = "Поиск по фамилии")
//    @GetMapping("/findByFullName/{fullName}")
//    public List<ProfileDb> findByFullName(@PathVariable String fullName){
//        return profileService.findByFullName(fullName);
//    }
//    @ApiOperation(value = "Список для Обзвона", notes = "Список для обзвона")
//    @GetMapping("/findCallProfile")
//    public List<CallActiveProfileDto> findCallProfile(){
//        return profileService.findCallProfile();
//    }

//    @ApiOperation(value = "Поиск по ИНН паспорта", notes = "Поиск по ИНН паспорта")
//    @GetMapping("/findByPassportInn/{passportInn}")
//    public List<ProfileDb> findByPassportInn(@PathVariable String passportInn){
//        return profileService.findByPassportInn(passportInn);
//    }
    @ApiOperation(value = "Добавить новый профиль в таблицу", notes = "Добавить новый профиль в таблицу")
    @PostMapping("/addProfiles")
    public ProfileDb addProfiles(@RequestBody ProfileDto profileDto){
        return profileService.addProfiles(profileDto);
    }

    @ApiOperation(value = "Изменить данные по профилю", notes = "Изменить данные по профилю")
    @PutMapping("/editProfiles")
    public Optional<ProfileDb> editProfiles(@RequestBody ProfileDb profileDb){
        return profileService.editUserProfile(profileDb);
    }
//    @ApiOperation(value = "Поиск по ИНН паспорта", notes = "Поиск по ИНН паспорта")
//    @GetMapping("/findProfileByDate/{start}/{end}")
//    public List<ProfileDb> findByProfileByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
//                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end){
//        return profileService.findProfileByPeriod(start,end);
//    }
    @ApiOperation(value = "DTO for Main Page", notes = "DTO for Main Page")
    @GetMapping("/getDtoForMain/{start}/{end}")
    public List<MainDashProfileDto> getDtoForMain (@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                   @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end){
        return profileService.findProfileForDash(start,end);
    }
    @ApiOperation(value = "DTO find by Full name in Main Page", notes = "DTO find by Full name in Main Page")
    @GetMapping("/getDtoForMainByFullName/{fullName}")
    public List<MainDashProfileDto> getDtoForMainByFullName (@PathVariable String fullName){
        return profileService.findProfileByFullName(fullName);
    }

    @ApiOperation(value = "DTO find by Device IMEI in Main Page", notes = "DTO find by Device IMEI in Main Page")
    @GetMapping("/getDtoForMainByDeviceImei/{deviceImei}")
    public List<MainDashProfileDto> getDtoForMainByDeviceImei (@PathVariable String deviceImei) {
        return profileService.findProfileByDeviceImei(deviceImei);
    }
    @ApiOperation(value = "DTO find by Device IMEI in Main Page", notes = "DTO find by Device IMEI in Main Page")
    @GetMapping("/getDtoForMainByPassInn/{passportInn}")
    public List<MainDashProfileDto> getDtoForMainByPassInn (@PathVariable String passportInn) {
        return profileService.findProfileByPassportInn(passportInn);
    }
    @ApiOperation(value = "new call profile where distinct credit_id", notes = "new call profile where distinct credit_id")
    @GetMapping("/findDistinctCallProfile")
    public List<DistinctCallProfileDto> findDistinctCallProfile(){
        return profileService.distinctCallProfile();
    }
    @ApiOperation(value = "Change delete status by profile_id", notes = "Change delete status by profile_id")
    @PostMapping("/deleteStatus")
    Optional<ProfileDb> deleteProfileStatus(@RequestBody DeletedStatusDto deletedStatusDto) {
       return profileService.deleteProfileStatus(deletedStatusDto);
    }
}

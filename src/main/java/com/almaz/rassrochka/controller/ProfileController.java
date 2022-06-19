package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.CallActiveProfileDto;
import com.almaz.rassrochka.domain.dto.ProfileDto;
import com.almaz.rassrochka.domain.repository.CallProfileDto;
import com.almaz.rassrochka.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "Получить список всех пользователей", notes = "Получить список всех пользователей")
    @GetMapping("/findAll")
    public List<ProfileDb> findAll(){
        return profileService.findAll();
    }

    @ApiOperation(value = "Получить пользователя по ID", notes = "Получить пользователя по ID")
    @GetMapping("/findById/{id}")
    public Optional<ProfileDb> findById(@PathVariable Long id){
        return profileService.findById(id);
    }

    @ApiOperation(value = "Поиск по фамилии", notes = "Поиск по фамилии")
    @GetMapping("/findByFullName/{fullName}")
    public List<ProfileDb> findByFullName(@PathVariable String fullName){
        return profileService.findByFullName(fullName);
    }

    @ApiOperation(value = "Список для Обзвона", notes = "Список для обзвона")
    @GetMapping("/findCallProfile")
    public List<CallActiveProfileDto> findCallProfile(){
        return profileService.findCallProfile();
    }

    @ApiOperation(value = "Поиск по ИНН паспорта", notes = "Поиск по ИНН паспорта")
    @GetMapping("/findByPassportInn/{passportInn}")
    public List<ProfileDb> findByPassportInn(@PathVariable String passportInn){
        return profileService.findByPassportInn(passportInn);
    }

    @ApiOperation(value = "Добавить новый профиль в таблицу", notes = "Добавить новый профиль в таблицу")
    @PostMapping("/addProfiles")
    public ProfileDb addProfiles(@RequestBody ProfileDto profileDto){
        return profileService.addProfiles(profileDto);
    }


}

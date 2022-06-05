package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "Добавить новый профиль в таблицу", notes = "Добавить новый профиль в таблицу")
    @PostMapping("/addProfiles")
    public ProfileDb addProfiles(@RequestBody ProfileDb profileDb){
        return profileService.addProfiles(profileDb);
    }


}

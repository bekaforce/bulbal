package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.BrotherDb;
import com.almaz.rassrochka.service.BrotherService;
import com.almaz.rassrochka.domain.dto.BrotherDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.almaz.rassrochka.endpoints.Endpoints.BROTHER;

@RestController
@CrossOrigin
@RequestMapping(value = BROTHER)
public class BrotherController {
    private final BrotherService brotherService;

    public BrotherController(BrotherService brotherService) {
        this.brotherService = brotherService;
    }

    @ApiOperation(value = "Добавить нового поручителя в таблицу DTO", notes = "Добавить нового поручителя в таблицу DTO")
    @PostMapping("/addBrothersDto")
    public BrotherDb addBrotherDto(@RequestBody BrotherDto brotherDto){
        return brotherService.addBrotherDto(brotherDto);
    }

    @ApiOperation(value = "Поиск поручителя по ProfileId", notes = "Поиск поручителя по ProfileIdId")
    @GetMapping("/getBrothersById/{id}")
    public List<BrotherDb> findByProfileId(@PathVariable Long id){
        return brotherService.findByProfileId(id);
    }
    @ApiOperation(value = "Обновить поручителя", notes = "Обновить поручителя")
    @PutMapping("/editBrothers")
    public Optional<BrotherDb> editBrothers (@RequestBody BrotherDto brotherDto){
        return brotherService.editBrother(brotherDto);
    }
}

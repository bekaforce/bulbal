package com.almaz.bulbal.controller.house;


import com.almaz.bulbal.controller.Url;
import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfHouse;
import com.almaz.bulbal.service.house.impl.TypeOfHouseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = Url.ADMIN_API + Url.TYPEOFHOUSE)
public class TypeOfHouseController {
    private final TypeOfHouseServiceImpl typeOfHouseService;

    public TypeOfHouseController(TypeOfHouseServiceImpl typeOfHouseService) {
        this.typeOfHouseService = typeOfHouseService;
    }

    @DeleteMapping(Url.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = typeOfHouseService.deleteById(id);
        return response
                ? new ResponseEntity<>("TypeOfHouse was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Url.SAVE)
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        TypeOfHouse response = typeOfHouseService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Url.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody GetNameDto getNameDto, @PathVariable(value = "id") Long id){
        TypeOfHouse response = typeOfHouseService.update(getNameDto, id);
        return response != null
                ? new ResponseEntity<>("TypeOfHouse was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<TypeOfHouse> response = typeOfHouseService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

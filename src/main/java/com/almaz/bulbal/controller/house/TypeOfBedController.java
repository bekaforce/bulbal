package com.almaz.bulbal.controller.house;


import com.almaz.bulbal.controller.Url;
import com.almaz.bulbal.dto.project.GetMapDto;
import com.almaz.bulbal.model.house.TypeOfBed;
import com.almaz.bulbal.service.house.impl.TypeOfBedServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = Url.ADMIN_API + Url.TYPEOFBED)
public class TypeOfBedController {
    private final TypeOfBedServiceImpl typeOfBedService;

    public TypeOfBedController(TypeOfBedServiceImpl typeOfBedService) {
        this.typeOfBedService = typeOfBedService;
    }

    @DeleteMapping(Url.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = typeOfBedService.deleteById(id);
        return response
                ? new ResponseEntity<>("TypeOfBed was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Url.SAVE)
    public ResponseEntity<?> save(@RequestBody GetMapDto getMapDto){
        TypeOfBed response = typeOfBedService.save(getMapDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Url.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody GetMapDto getMapDto, @PathVariable(value = "id") Long id){
        TypeOfBed response = typeOfBedService.update(getMapDto, id);
        return response != null
                ? new ResponseEntity<>("TypeOfBed was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<TypeOfBed> response = typeOfBedService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

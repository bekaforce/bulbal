package com.almaz.bulbal.controller.house;


import com.almaz.bulbal.dto.project.GetMapDto;
import com.almaz.bulbal.model.house.TypeOfBed;
import com.almaz.bulbal.service.house.impl.TypeOfBedServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.TYPEOFBED;


@RestController
@CrossOrigin
@RequestMapping(value = TYPEOFBED)
public class TypeOfBedController {
    private final TypeOfBedServiceImpl typeOfBedService;

    public TypeOfBedController(TypeOfBedServiceImpl typeOfBedService) {
        this.typeOfBedService = typeOfBedService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = typeOfBedService.deleteById(id);
        return response
                ? new ResponseEntity<>("TypeOfBed was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GetMapDto getMapDto){
        TypeOfBed response = typeOfBedService.save(getMapDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody GetMapDto getMapDto, @PathVariable(value = "id") Long id){
        TypeOfBed response = typeOfBedService.update(getMapDto, id);
        return response != null
                ? new ResponseEntity<>("TypeOfBed was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<TypeOfBed> response = typeOfBedService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

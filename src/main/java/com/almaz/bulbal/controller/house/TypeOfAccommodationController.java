package com.almaz.bulbal.controller.house;


import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfAccommodation;
import com.almaz.bulbal.service.house.impl.TypeOfAccommodationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.TYPEOFACCOMMODATION;

@RestController
@CrossOrigin
@RequestMapping(value = TYPEOFACCOMMODATION)
public class TypeOfAccommodationController {
    private final TypeOfAccommodationServiceImpl typeOfAccommodationService;

    public TypeOfAccommodationController(TypeOfAccommodationServiceImpl typeOfAccommodationService) {
        this.typeOfAccommodationService = typeOfAccommodationService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = typeOfAccommodationService.deleteById(id);
        return response
                ? new ResponseEntity<>("TypeOfAccommodation was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        TypeOfAccommodation response = typeOfAccommodationService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody GetNameDto getNameDto, @PathVariable(value = "id") Long id){
        TypeOfAccommodation response = typeOfAccommodationService.update(getNameDto, id);
        return response != null
                ? new ResponseEntity<>("TypeOfAccommodation was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<TypeOfAccommodation> response = typeOfAccommodationService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

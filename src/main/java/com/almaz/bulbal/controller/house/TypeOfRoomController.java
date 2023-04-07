package com.almaz.bulbal.controller.house;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfRoom;
import com.almaz.bulbal.service.house.impl.TypeOfRoomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.TYPEOFROOM;

@RestController
@CrossOrigin
@RequestMapping(value = TYPEOFROOM)
public class TypeOfRoomController {
    private final TypeOfRoomServiceImpl typeOfRoomService;

    public TypeOfRoomController(TypeOfRoomServiceImpl typeOfRoomService) {
        this.typeOfRoomService = typeOfRoomService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = typeOfRoomService.deleteById(id);
        return response
                ? new ResponseEntity<>("TypeOfRoom was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        TypeOfRoom response = typeOfRoomService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody GetNameDto getNameDto, @PathVariable(value = "id") Long id){
        TypeOfRoom response = typeOfRoomService.update(getNameDto, id);
        return response != null
                ? new ResponseEntity<>("TypeOfRoom was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<TypeOfRoom> response = typeOfRoomService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

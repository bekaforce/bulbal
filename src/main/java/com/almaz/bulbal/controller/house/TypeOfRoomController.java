package com.almaz.bulbal.controller.house;

import com.almaz.bulbal.controller.Url;
import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.TypeOfRoom;
import com.almaz.bulbal.service.house.impl.TypeOfRoomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = Url.ADMIN_API + Url.TYPEOFROOM)
public class TypeOfRoomController {
    private final TypeOfRoomServiceImpl typeOfRoomService;

    public TypeOfRoomController(TypeOfRoomServiceImpl typeOfRoomService) {
        this.typeOfRoomService = typeOfRoomService;
    }

    @DeleteMapping(Url.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = typeOfRoomService.deleteById(id);
        return response
                ? new ResponseEntity<>("TypeOfRoom was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Url.SAVE)
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        TypeOfRoom response = typeOfRoomService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Url.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody GetNameDto getNameDto, @PathVariable(value = "id") Long id){
        TypeOfRoom response = typeOfRoomService.update(getNameDto, id);
        return response != null
                ? new ResponseEntity<>("TypeOfRoom was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<TypeOfRoom> response = typeOfRoomService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

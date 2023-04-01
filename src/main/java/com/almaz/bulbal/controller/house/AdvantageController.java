package com.almaz.bulbal.controller.house;

import com.almaz.bulbal.controller.Url;
import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.Advantage;
import com.almaz.bulbal.service.house.impl.AdvantageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = Url.ADMIN_API + Url.ADVANTAGE)
public class AdvantageController {
    private final AdvantageServiceImpl advantageService;

    public AdvantageController(AdvantageServiceImpl advantageService) {
        this.advantageService = advantageService;
    }

    @DeleteMapping(Url.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = advantageService.delete(id);
        return response
                ? new ResponseEntity<>("Advantage was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Url.SAVE)
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        Advantage response = advantageService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Url.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody GetNameDto getNameDto, @PathVariable(value = "id") Long id){
        Advantage response = advantageService.update(id, getNameDto);
        return response != null
                ? new ResponseEntity<>("Advantage was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<Advantage> response = advantageService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

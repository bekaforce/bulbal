package com.almaz.bulbal.controller.location;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.location.Region;
import com.almaz.bulbal.service.location.impl.RegionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.REGION;

@RestController
@CrossOrigin
@RequestMapping(value = REGION)
public class RegionController {
    private final RegionServiceImpl regionService;

    public RegionController(RegionServiceImpl regionService) {
        this.regionService = regionService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = regionService.deleteById(id);
        return response
                ? new ResponseEntity<>("Region was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        Region response = regionService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody GetNameDto getNameDto, @PathVariable(value = "id") Long id){
        Region response = regionService.update(getNameDto, id);
        return response != null
                ? new ResponseEntity<>("Region was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Region> response = regionService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.example.admin_bulbal.controller.location;

import com.example.admin_bulbal.controller.Url;
import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.location.Region;
import com.example.admin_bulbal.service.location.impl.RegionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = Url.ADMIN_API + Url.REGION)
public class RegionController {
    private final RegionServiceImpl regionService;

    public RegionController(RegionServiceImpl regionService) {
        this.regionService = regionService;
    }

    @DeleteMapping(Url.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = regionService.deleteById(id);
        return response
                ? new ResponseEntity<>("Region was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Url.SAVE)
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        Region response = regionService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Url.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody GetNameDto getNameDto, @PathVariable(value = "id") Long id){
        Region response = regionService.update(getNameDto, id);
        return response != null
                ? new ResponseEntity<>("Region was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<Region> response = regionService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

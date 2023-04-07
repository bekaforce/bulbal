package com.almaz.bulbal.controller.location;

import com.almaz.bulbal.dto.location.GetLocalityDto;
import com.almaz.bulbal.model.location.Locality;
import com.almaz.bulbal.service.location.impl.LocalityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.LOCALITY;

@RestController
@CrossOrigin
@RequestMapping(value = LOCALITY)
public class LocalityController {
    private final LocalityServiceImpl localityService;

    public LocalityController(LocalityServiceImpl localityService) {
        this.localityService = localityService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = localityService.deleteById(id);
        return response
                ? new ResponseEntity<>("Locality was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GetLocalityDto getLocalityDto){
        Locality response = localityService.save(getLocalityDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody GetLocalityDto getLocalityDto, @PathVariable(value = "id") Long id){
        Locality response = localityService.update(getLocalityDto, id);
        return response != null
                ? new ResponseEntity<>("Locality was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all/{region_id}")
    public ResponseEntity<?> all(@PathVariable(value = "region_id") Long region_id){
        List<Locality> response = localityService.allByRegionId(region_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

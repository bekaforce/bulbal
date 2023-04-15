package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.AccommodationDto;
import com.almaz.bulbal.dto.main.CreateAccommodationDto;
import com.almaz.bulbal.dto.main.CreateRoomDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Residence;
import com.almaz.bulbal.service.main.impl.ResidenceServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.almaz.bulbal.endpoints.Endpoints.RESIDENCE;

@RestController
@RequestMapping(value = RESIDENCE)
@CrossOrigin
public class ResidenceController {
    private final ResidenceServiceImpl residenceService;

    public ResidenceController(ResidenceServiceImpl residenceService) {
        this.residenceService = residenceService;
    }

    @PostMapping(value = "/save")
    public Residence save (@RequestBody Residence residence){
        return residenceService.save(residence);
    }

    @GetMapping(value = "/{id}")
    public Residence residenceById(@PathVariable(value = "id") Long id){
        return residenceService.residenceById(id);
    }

    @GetMapping(value = "/all")
    public List<Residence> all (){
        return residenceService.all();
    }

    @PutMapping(value = "/edit")
    public Residence edit (@RequestBody Residence residence){
        return residenceService.update(residence);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable(value = "id") Long id){
        return residenceService.delete(id);
    }
}

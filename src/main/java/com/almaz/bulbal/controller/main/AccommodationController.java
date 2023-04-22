package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.AccommodationDto;
import com.almaz.bulbal.dto.main.CreateAccommodationDto;
import com.almaz.bulbal.dto.main.CreateBedsDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.service.main.AccommodationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.almaz.bulbal.endpoints.Endpoints.ACCOMMODATION;

@RestController
@RequestMapping(value = ACCOMMODATION)
@CrossOrigin
public class AccommodationController {
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @PostMapping(value = "/saveAccommodation")
    public Accommodation saveAccommodation (@RequestBody CreateAccommodationDto createAccommodationDto){
        return accommodationService.saveAccommodation(createAccommodationDto);
    }

    @PostMapping(value = "/saveBeds")
    public Accommodation saveBeds(@RequestBody CreateBedsDto createBedsDto){
        return accommodationService.saveBeds(createBedsDto);
    }
    @GetMapping(value = "/{id}")
    public Accommodation accommodationById(@PathVariable(value = "id") Long id){
        return accommodationService.accommodationById(id);
    }

    @GetMapping(value = "/all")
    public List<Accommodation> all (){
        return accommodationService.all();
    }

    @PutMapping(value = "/editAccommodation")
    public Optional<Accommodation> editAccommodation (@RequestBody AccommodationDto accommodationDto){
        return accommodationService.editAccommodation(accommodationDto);
    }


}

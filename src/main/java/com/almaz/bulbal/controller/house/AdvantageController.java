package com.almaz.bulbal.controller.house;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.Advantage;
import com.almaz.bulbal.service.house.impl.AdvantageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.ADVANTAGE;

@RestController
@CrossOrigin
@RequestMapping(value = ADVANTAGE)
public class AdvantageController {
    private final AdvantageServiceImpl advantageService;

    public AdvantageController(AdvantageServiceImpl advantageService) {
        this.advantageService = advantageService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = advantageService.delete(id);
        return response
                ? new ResponseEntity<>("Advantage was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GetNameDto getNameDto){
        Advantage response = advantageService.save(getNameDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping( "/update/{id}")
    public ResponseEntity<?> update(@RequestParam("multipartFile") MultipartFile multipartFile,
                                    @RequestParam("convenienceName")String convenienceName,
                                    @PathVariable("id") Long id) throws IOException {
        Advantage response = advantageService.update(multipartFile, id, convenienceName);
        return response != null
                ? new ResponseEntity<>("Advantage was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Advantage> response = advantageService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public void uploadIcon(@RequestParam("multipartFile") MultipartFile multipartFile,
                                        @RequestParam("convenienceName")String convenienceName,
                                        @Validated HttpServletResponse response) throws IOException {
        if (multipartFile != null) {
            response.setHeader("Content-Disposition", "Success. Upload file");
        } else {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        advantageService.saveIcon(multipartFile, convenienceName);
    }
}

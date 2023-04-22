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
    public ResponseEntity<?> save(@RequestParam String name, @RequestParam("multipartFile") MultipartFile multipartFile,
                                  @Validated HttpServletResponse result) throws IOException {
        Advantage response = new Advantage();
        if (multipartFile != null) {
            result.setHeader("Content-Disposition", "Success. Upload file");
            response = advantageService.save(name, multipartFile);
        } else {
            result.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping( "/update/{id}")
    public ResponseEntity<?> update(@RequestParam String name, @RequestParam("multipartFile") MultipartFile multipartFile,
                                    @Validated HttpServletResponse result, @PathVariable Long id) throws IOException {
        Advantage response = new Advantage();
        if (multipartFile != null) {
            result.setHeader("Content-Disposition", "Success. Upload file");
            response = advantageService.update(multipartFile, name, id);
        } else {
            result.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return response != null
                ? new ResponseEntity<>("Advantage was updated by id: " + response.getId(), HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Advantage> response = advantageService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

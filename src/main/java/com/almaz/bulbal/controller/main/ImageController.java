package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.model.main.Image;
import com.almaz.bulbal.service.main.impl.ImageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.IMAGES;


@RestController
@RequestMapping(value = IMAGES)
@CrossOrigin
public class ImageController {
    private final ImageServiceImpl imageService;

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload/{accommodation_id}")
    public ResponseEntity<?> upload(@RequestParam("multipartFile") MultipartFile multipartFile, @PathVariable(name = "accommodation_id") Long accommodation_id) throws IOException {
        boolean response = imageService.upload(multipartFile, accommodation_id);
        return response
                ? new ResponseEntity<>("File was uploaded successfully", HttpStatus.OK)
                : new ResponseEntity<>("File hasn't got any file or couldn't upload it", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteFileById/{id}")
    public ResponseEntity<?> deleteFileById(@PathVariable(value = "id") Long id){
        boolean response = imageService.delete(id);
        return response
                ? new ResponseEntity<>("File was deleted by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findAllByAccommodationId")
    public List<Image> findAllByAccommodationId(@RequestBody Long id) {

        return imageService.findAllByAccommodationId(id);
    }


}

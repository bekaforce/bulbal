package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.service.main.impl.ImageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.almaz.bulbal.controller.Url.IMAGE;

@RestController
@RequestMapping(value = IMAGE)
@CrossOrigin
public class ImageController {
    private final ImageServiceImpl imageService;

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload/{mainHouse_id}")
    public ResponseEntity<?> upload(@RequestParam("multipartFile") MultipartFile multipartFile, @PathVariable(name = "mainHouse_id") Long mainHouse_id) throws IOException {
        boolean response = imageService.upload(multipartFile, mainHouse_id);
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


}

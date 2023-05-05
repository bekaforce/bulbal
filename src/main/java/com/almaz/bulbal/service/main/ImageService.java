package com.almaz.bulbal.service.main;

import com.almaz.bulbal.model.main.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


public interface ImageService {
    Image uploadImage(MultipartFile multipartFile, Long accommodation_id) throws IOException;
    Image uploadMainImageNew (MultipartFile multipartFile, Long accommodation_id, Boolean main) throws IOException;
    Image uploadAvatar (MultipartFile multipartFile, Long userId) throws IOException;
    boolean delete(Long id);
    File findFileByFileName(String fileName);

    Image imageById(Long id);

    List<Image> findAllByAccommodationId(Long id);

    List<Image> findFiveByAccommodationId(Long id);
}

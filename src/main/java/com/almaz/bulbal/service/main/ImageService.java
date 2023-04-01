package com.almaz.bulbal.service.main;

import com.almaz.bulbal.model.main.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


public interface ImageService {
    boolean upload(MultipartFile multipartFile, Long mainHouse_id) throws IOException;
    boolean delete(Long id);
    File findFileByFileName(String fileName);

    Image imageById(Long id);

}

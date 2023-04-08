package com.almaz.bulbal.service.main.impl;


import com.almaz.bulbal.model.main.Image;
import com.almaz.bulbal.model.main.MainHouse;
import com.almaz.bulbal.repository.main.ImageRepo;
import com.almaz.bulbal.service.main.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepo imageRepo;
    private final MainHouseServiceImpl mainHouseService;
    @Value("${server-config.upload-path}")
    private String UPLOADED_FOLDER;

    public ImageServiceImpl(ImageRepo imageRepo, MainHouseServiceImpl mainHouseService) {
        this.imageRepo = imageRepo;
        this.mainHouseService = mainHouseService;
    }

    @Override
    public boolean upload(MultipartFile multipartFile, Long mainHouse_id) throws IOException {
        if (multipartFile != null && !multipartFile.toString().equals("")){
            File uploadDir = new File(UPLOADED_FOLDER);
            String uuidFile = UUID.randomUUID().toString();
            String fileName = uuidFile +"_-_"+ multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(uploadDir + "/" + fileName));
            MainHouse mainHouse = mainHouseService.mainHouseById(mainHouse_id);
            Image image = new Image(fileName, mainHouse);
            imageRepo.save(image);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Image image = imageById(id);
        File file = findFileByFileName(image.getFileName());
        if (file != null){
            file.delete();
            imageRepo.delete(image);
            return true;
        }
        return false;
    }

    @Override
    public File findFileByFileName(String fileName) {
        File dir = new File(UPLOADED_FOLDER);
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files){
            if (file.getName().equals(fileName)){
                return file;
            }
        }
        return null;
    }

    @Override
    public Image imageById(Long id) {
        return imageRepo.findImageById(id);
    }

    @Override
    public List<Image> findAllByHouseId(Long id) {
        return imageRepo.findAllByMainHouse_Id(id);
    }
}

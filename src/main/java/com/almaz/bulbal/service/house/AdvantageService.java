package com.almaz.bulbal.service.house;


import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.Advantage;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AdvantageService {
    Advantage save(GetNameDto getNameDto);
    Advantage update(Long id, GetNameDto getNameDto);
    boolean delete(Long id);
    File findFileByFileName(String fileName);
    List<Advantage> all();

    Advantage advantageById(Long id);
    void saveIcon(MultipartFile multipartFile, String name) throws IOException;

}

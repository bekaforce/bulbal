package com.almaz.bulbal.service.house.impl;

import com.almaz.bulbal.dto.project.GetNameDto;
import com.almaz.bulbal.model.house.Advantage;
import com.almaz.bulbal.repository.house.AdvantageRepo;
import com.almaz.bulbal.service.house.AdvantageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class AdvantageServiceImpl implements AdvantageService {
    private final AdvantageRepo advantageRepo;

    public AdvantageServiceImpl(AdvantageRepo advantageRepo) {
        this.advantageRepo = advantageRepo;
    }

    @Value("${server-config.upload-path}")
    private String UPLOADED_FOLDER;

    @Override
    public Advantage save(GetNameDto getNameDto) {
        Advantage advantage = new Advantage(getNameDto.getName());
        return advantageRepo.save(advantage);
    }

    @Override
    public Advantage update(Long id, GetNameDto getNameDto) {
        Advantage advantage = advantageById(id);
        if (advantage != null) {
            advantage.setConvenienceName(getNameDto.getName());
            return advantageRepo.save(advantage);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Advantage advantage = advantageById(id);
        File file = findFileByFileName(advantage.getIcon());
        if (file != null) {
            file.delete();
            advantageRepo.delete(advantage);
            return true;
        }
        return false;
    }

    @Override
    public File findFileByFileName(String fileName) {
        File dir = new File(UPLOADED_FOLDER+"/icon");
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
    public List<Advantage> all() {
        return advantageRepo.findAll();
    }

    @Override
    public Advantage advantageById(Long id) {
        return advantageRepo.findAdvantageById(id);
    }

    @Override
    public void saveIcon(MultipartFile multipartFile, String convenienceName) throws IOException {
        if (multipartFile != null) {
            File upload = new File(UPLOADED_FOLDER+"/icon");

            if (!upload.exists()) {
                upload.mkdir();
            }
        }
        if (multipartFile != null) {

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile +"_-_"+ multipartFile.getOriginalFilename();

            multipartFile.transferTo(new File(UPLOADED_FOLDER+"/icon" + "/" + resultFileName));
            Advantage advantage = new Advantage();
            advantage.setConvenienceName(convenienceName);
            advantage.setIcon(resultFileName);
            advantageRepo.save(advantage);
        }
    }
}

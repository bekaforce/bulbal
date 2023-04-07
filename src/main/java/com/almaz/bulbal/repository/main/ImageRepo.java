package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
    Image findImageById(Long id);

    List<Image> findAllByMainHouse_Id(Long id);
}

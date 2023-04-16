package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
    Image findImageById(Long id);

    @Query(value = "select * from image i " +
            "where i.accommodation_id = :id " +
            "and i.main is not true", nativeQuery = true)
    List<Image> findAllByAccommodation_Id(@Param(value = "id") Long id);

    @Query(value = "select * from image i " +
            "where i.accommodation_id = :id " +
            "and i.main is not true " +
            "limit 5", nativeQuery = true)
    List<Image> findFiveByAccommodation_id(@Param(value = "id") Long id);
}

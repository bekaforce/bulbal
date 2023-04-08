package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepo extends JpaRepository<Accommodation, Long> {
    Accommodation findAccommodationById(Long id);
}

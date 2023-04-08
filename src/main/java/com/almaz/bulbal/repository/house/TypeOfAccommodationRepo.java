package com.almaz.bulbal.repository.house;

import com.almaz.bulbal.model.house.TypeOfAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfAccommodationRepo extends JpaRepository<TypeOfAccommodation, Long> {
    TypeOfAccommodation findTypeOfAccommodationById(Long id);
}

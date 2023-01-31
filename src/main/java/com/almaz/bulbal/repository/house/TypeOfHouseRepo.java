package com.almaz.bulbal.repository.house;

import com.almaz.bulbal.model.house.TypeOfHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfHouseRepo extends JpaRepository<TypeOfHouse, Long> {
    TypeOfHouse findTypeOfHouseById(Long id);
}

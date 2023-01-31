package com.almaz.bulbal.repository.house;

import com.almaz.bulbal.model.house.TypeOfRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfRoomRepo extends JpaRepository<TypeOfRoom, Long> {
    TypeOfRoom findTypeOfRoomById(Long id);
}

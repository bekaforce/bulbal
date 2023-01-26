package com.example.admin_bulbal.repository.house;

import com.example.admin_bulbal.model.house.TypeOfRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfRoomRepo extends JpaRepository<TypeOfRoom, Long> {

}

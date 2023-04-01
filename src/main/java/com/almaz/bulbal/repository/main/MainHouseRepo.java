package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.MainHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainHouseRepo extends JpaRepository<MainHouse, Long> {
    MainHouse findMainHouseByOwnerId(Long id);
}

package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.DeviceDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceDbRepo extends JpaRepository<DeviceDb, Long> {

    List<DeviceDb> findAllByProfileId(Long id);

}

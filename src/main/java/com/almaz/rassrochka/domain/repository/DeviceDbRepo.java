package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.DeviceDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDbRepo extends JpaRepository<DeviceDb, Long> {
}

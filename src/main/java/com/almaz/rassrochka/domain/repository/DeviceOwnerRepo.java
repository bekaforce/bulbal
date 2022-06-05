package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceOwnerRepo extends JpaRepository<DeviceOwnerDb, Long> {
}

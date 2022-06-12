package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.CreditDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditDbRepo extends JpaRepository<CreditDb, Long> {

    List<CreditDb> findAllByDeviceId(Long id);

}

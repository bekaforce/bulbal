package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.MonthCreditDb;
import com.almaz.rassrochka.enums.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MonthCreditDbRepo extends JpaRepository<MonthCreditDb, Long> {
    List<MonthCreditDb> findAllByDeviceId(Long id);

    List<MonthCreditDb> findAllByStatusType(@Param("statusType")StatusType statusType);
}

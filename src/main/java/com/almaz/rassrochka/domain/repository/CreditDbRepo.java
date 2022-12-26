package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.CreditDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditDbRepo extends JpaRepository<CreditDb, Long> {

    List<CreditDb> findAllByDeviceId(Long id);

    CreditDb findAllById(Long id);

//    @Query(value = "select c.id from azamat.credit c where c.device_id =:deviceId",
//            nativeQuery = true)
//    Long findByDeviceId(@Param("deviceId") Long deviceId);

}

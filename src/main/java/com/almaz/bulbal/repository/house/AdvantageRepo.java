package com.almaz.bulbal.repository.house;

import com.almaz.bulbal.model.house.Advantage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvantageRepo extends JpaRepository<Advantage, Long> {
    Advantage findAdvantageById(Long id);
}

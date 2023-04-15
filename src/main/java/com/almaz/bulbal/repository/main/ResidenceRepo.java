package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceRepo extends JpaRepository<Residence, Long> {
    Residence findResidenceById(Long id);
}

package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Convenience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenienceRepo extends JpaRepository<Convenience, Long> {
}

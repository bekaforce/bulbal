package com.almaz.bulbal.repository.location;

import com.almaz.bulbal.model.location.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {
    Region findRegionById(Long id);
}

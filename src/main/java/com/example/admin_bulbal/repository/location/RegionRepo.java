package com.example.admin_bulbal.repository.location;

import com.example.admin_bulbal.model.location.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {
    Region findRegionById(Long id);
}

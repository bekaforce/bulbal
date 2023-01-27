package com.example.admin_bulbal.repository.location;

import com.example.admin_bulbal.model.location.Locality;
import com.example.admin_bulbal.model.location.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalityRepo extends JpaRepository<Locality, Long> {
    Locality findLocalityById(Long id);
    List<Locality> findAllByRegion(Region region);
}

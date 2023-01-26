package com.example.admin_bulbal.repository.location;

import com.example.admin_bulbal.model.location.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepo extends JpaRepository<Locality, Long> {
}

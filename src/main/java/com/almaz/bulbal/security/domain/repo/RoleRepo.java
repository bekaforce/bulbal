package com.almaz.bulbal.security.domain.repo;

import com.almaz.bulbal.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

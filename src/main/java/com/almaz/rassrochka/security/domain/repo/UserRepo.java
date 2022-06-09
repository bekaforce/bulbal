package com.almaz.rassrochka.security.domain.repo;

import com.almaz.rassrochka.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String name);
}


package com.almaz.rassrochka.security.domain.repo;

import com.almaz.rassrochka.domain.repository.CallProfileDto;
import com.almaz.rassrochka.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String name);

    @Query(value = "SELECT s.username as name FROM public.users s\n" +
            "order by s.username asc", nativeQuery = true)
    List<Object> findUserName();
}


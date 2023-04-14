package com.almaz.bulbal.security.domain.repo;

import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.dto.GetUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "SELECT s.username as name FROM public.users s\n" +
            "order by s.username asc", nativeQuery = true)
    List<Object> findUserName();


    @Query(value = "SELECT otp FROM public.users x where username =:email", nativeQuery = true)
    String getOtpByEmail(@Param("email")String email);
    @Query(value = "SELECT id FROM public.users x where username =:email", nativeQuery = true)
    Long getIdByUserName(@Param("email")String email);

    @Query(value = "SELECT personal_pass FROM public.users x where username =:email", nativeQuery = true)
    String getPersonalPass(@Param("email")String email);

    @Query(value = "select u.first_name as name from users u, accommodation a " +
            "where u.id = a.owner_id " +
            "and a.owner_id = :id " +
            "group by u.first_name", nativeQuery = true)
    GetUserDto getUserDtoById(Long id);


}


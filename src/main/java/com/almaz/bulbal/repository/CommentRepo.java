package com.almaz.bulbal.repository;

import com.almaz.bulbal.dto.main.GetCommentDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Query(value = "select c.id, c.created_at as createdAt, c.text, u.first_name as firstName, u.last_name as lastName " +
            "from comment c " +
            "left join users u " +
            "ON c.user_id = u.id " +
            "where c.accommodation_id = :accommodationId", nativeQuery = true)
    List<GetCommentDto> getCommentsByAccommodationId(@Param(value = "accommodationId") Long accommodationId);
}

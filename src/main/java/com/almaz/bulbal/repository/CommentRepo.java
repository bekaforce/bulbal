package com.almaz.bulbal.repository;

import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    Comment findCommentById(Long id);

    List<Comment> findAllByAccommodationId(Long accommodationId);
}

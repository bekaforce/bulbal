package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.CommentDto;
import com.almaz.bulbal.model.main.Comment;

import java.util.List;

public interface CommentService {
    Comment save(CommentDto commentDto);
    void setComment(Comment comment, CommentDto commentDto);
    List<Comment> allByAccommodationId(Long accommodationId);
}

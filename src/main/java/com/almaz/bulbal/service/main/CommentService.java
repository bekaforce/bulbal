package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.CommentDto;
import com.almaz.bulbal.dto.main.GetCommentDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Comment;

import java.util.List;

public interface CommentService {
    Comment save(CommentDto commentDto);
    void setComment(Comment comment, CommentDto commentDto, Accommodation accommodation);
    List<GetCommentDto> allByAccommodationId(Long accommodationId);
}

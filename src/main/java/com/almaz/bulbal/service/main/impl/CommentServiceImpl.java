package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.CommentDto;
import com.almaz.bulbal.dto.main.GetCommentDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Comment;
import com.almaz.bulbal.repository.CommentRepo;
import com.almaz.bulbal.security.domain.User;
import com.almaz.bulbal.security.service.impl.UserServiceImpl;
import com.almaz.bulbal.service.main.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final AccommodationServiceImpl accommodationService;
    private final CommentRepo commentRepo;

    public CommentServiceImpl(AccommodationServiceImpl accommodationService, CommentRepo commentRepo) {
        this.accommodationService = accommodationService;
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment save(CommentDto commentDto) {
        Accommodation accommodation = accommodationService.accommodationById(commentDto.getAccommodationId());
        if (accommodation != null){
            Comment comment = new Comment();
            setComment(comment, commentDto, accommodation);
            return commentRepo.save(comment);
        }
        return null;
    }

    @Override
    public void setComment(Comment comment, CommentDto commentDto, Accommodation accommodation) {
            comment.setAccommodation(accommodation);
            comment.setText(commentDto.getText());
            comment.setCreatedAt(LocalDateTime.now(ZoneId.of("Asia/Bishkek")));
            comment.setUserId(commentDto.getUserId());
    }

    @Override
    public List<GetCommentDto> allByAccommodationId(Long accommodationId) {
        return commentRepo.getCommentsByAccommodationId(accommodationId);
    }
}

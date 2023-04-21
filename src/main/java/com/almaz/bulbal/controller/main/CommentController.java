package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.CommentDto;
import com.almaz.bulbal.dto.main.CreateAccommodationDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Comment;
import com.almaz.bulbal.service.main.impl.CommentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.COMMENT;

@RestController
@RequestMapping(value = COMMENT)
@CrossOrigin
public class CommentController {
    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/save")
    public Comment save (@RequestBody CommentDto commentDto){
        return commentService.save(commentDto);
    }

    @GetMapping(value = "/allByAccommodationId/{accommodation_id}")
    public List<Comment> allByAccommodationId (@PathVariable(value = "accommodation_id") Long accommodationId){
        return commentService.allByAccommodationId(accommodationId);
    }
}

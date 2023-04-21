package com.almaz.bulbal.dto.main;

import lombok.Data;

@Data
public class CommentDto {
    private String text;
    private Long userId;
    private Long accommodationId;
}

package com.almaz.bulbal.dto.main;

import java.time.LocalDateTime;

public interface GetCommentDto {
    Long getId();
    LocalDateTime getCreatedAt();
    String getText();
    String getFirstName();
    String getLastName();
}

package com.almaz.bulbal.dto.project;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetLocalDateTimeDto {
    private LocalDateTime start;
    private LocalDateTime end;
    private String type;
}

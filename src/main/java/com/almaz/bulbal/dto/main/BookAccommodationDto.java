package com.almaz.bulbal.dto.main;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookAccommodationDto extends BookingDto {
    private Long accommodationId;
    private Long guests;
}

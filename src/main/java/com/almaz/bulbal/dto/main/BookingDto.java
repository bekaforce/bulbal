package com.almaz.bulbal.dto.main;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDto {
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}

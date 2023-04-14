package com.almaz.bulbal.dto.main;

import java.time.LocalDateTime;

public interface ReservationDto {
    String getAccommodationName();
    LocalDateTime getCheckIn();
    LocalDateTime getCheckOut();
    String getBookingStatus();
    String getPaymentStatus();
}

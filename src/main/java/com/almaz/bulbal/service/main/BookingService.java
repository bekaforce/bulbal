package com.almaz.bulbal.service.main;

import com.almaz.bulbal.dto.main.BookAccommodationDto;
import com.almaz.bulbal.dto.main.BookBedDto;
import com.almaz.bulbal.dto.main.ReservationDto;
import com.almaz.bulbal.model.main.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    Booking bookAccommodation(BookAccommodationDto bookingDto);

    Booking bookBed(BookBedDto bookingDto);
    void setBooking(Booking booking, LocalDateTime checkIn, LocalDateTime checkOut, Long guests, Long userId);

    List<Booking> bookBeds(List<BookBedDto> bookBedDtoList);

    Booking cancel(Long id);

    Booking bookingById(Long id);

    List<ReservationDto> allByUserId(Long userId);
}

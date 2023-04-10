package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.dto.main.BookAccommodationDto;
import com.almaz.bulbal.dto.main.BookBedDto;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Booking;
import com.almaz.bulbal.repository.main.BookingRepo;
import com.almaz.bulbal.service.main.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;

    public BookingServiceImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }



    @Override
    public Booking bookAccommodation(BookAccommodationDto bookingDto) {
        Booking booking = new Booking();
        booking.setStatus("Забронировано");
        booking.setAccommodationId(bookingDto.getAccommodationId());
        setBooking(booking, bookingDto.getCheckIn(), bookingDto.getCheckOut(), bookingDto.getGuests());
        return bookingRepo.save(booking);
    }

    @Override
    public Booking bookBed(BookBedDto bookingDto) {
        Booking booking = new Booking();
        booking.setStatus("Забронировано");
        booking.setBedId(bookingDto.getBedId());
        setBooking(booking, bookingDto.getCheckIn(), bookingDto.getCheckOut(), null);
        return bookingRepo.save(booking);
    }

    @Override
    public void setBooking(Booking booking, LocalDateTime checkIn, LocalDateTime checkOut, Long guests) {
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setGuests(guests);
    }

    @Override
    public List<Booking> bookBeds(List<BookBedDto> bookBedDtoList) {
        List<Booking> result = new ArrayList<>();
        for (BookBedDto bookBedDto : bookBedDtoList){
            Booking booking = bookBed(bookBedDto);
            result.add(booking);
        }
        return result;
    }

    @Override
    public Booking cancel(Long id) {
        Booking booking = bookingById(id);
        if (booking != null){
            booking.setStatus("Отменено");
            return bookingRepo.save(booking);
        }
        return null;
    }

    @Override
    public Booking bookingById(Long id) {
        return bookingRepo.findBookingById(id);
    }
}

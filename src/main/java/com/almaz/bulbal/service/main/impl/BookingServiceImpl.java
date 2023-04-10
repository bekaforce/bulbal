package com.almaz.bulbal.service.main.impl;

import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Booking;
import com.almaz.bulbal.repository.main.BookingRepo;
import com.almaz.bulbal.service.main.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;

    public BookingServiceImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking book(Long id) {

        return null;
    }
}

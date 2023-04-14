package com.almaz.bulbal.controller.main;

import com.almaz.bulbal.dto.main.BookAccommodationDto;
import com.almaz.bulbal.dto.main.BookBedDto;
import com.almaz.bulbal.dto.main.ReservationDto;
import com.almaz.bulbal.model.main.Booking;
import com.almaz.bulbal.service.main.impl.BookingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.almaz.bulbal.endpoints.Endpoints.BOOKING;

@RequestMapping(value = BOOKING)
@CrossOrigin
@RestController
public class BookingController {
    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(value = "/bookAccommodation")
    public Booking bookAccommodation (@RequestBody BookAccommodationDto bookingDto){
        return bookingService.bookAccommodation(bookingDto);
    }

    @PostMapping(value = "/bookBed")
    public List<Booking> bookBed (@RequestBody List<BookBedDto> bookingDto){
        return bookingService.bookBeds(bookingDto);
    }

    @GetMapping(value = "/{userId}")
    public List<ReservationDto> allByUserId(@PathVariable(value = "userId") Long userId){
        return bookingService.allByUserId(userId);
    }

}

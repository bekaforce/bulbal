package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.dto.main.ReservationDto;
import com.almaz.bulbal.model.main.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    Booking findBookingById(Long id);

    @Query(value = "select a.title_of_accommodation as accommodationName, b.check_in as checkIn, b.check_out as checkOut, b.booking_status as bookingStatus, b.payment_status as paymentStatus from accommodation a, booking b " +
            "where a.id = b.accommodation_id " +
            "and b.user_id = :userId", nativeQuery = true)
    List<ReservationDto> findAllByUserId(@Param(value = "userId") Long userId);
}

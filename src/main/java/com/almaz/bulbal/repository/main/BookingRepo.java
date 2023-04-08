package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

}

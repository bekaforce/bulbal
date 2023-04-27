package com.almaz.bulbal.model.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @Column(name = "accommodation_id")
    private Long accommodationId;
    @JsonIgnore
    @Column(name = "bed_id")
    private Long bedId;
    @JsonProperty("user_id")
    @Column(name = "user_id")
    private Long userId;
    private String bookingStatus;
    private String paymentStatus;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime bookingTime;
    private Long guests;
    private Long rentPayment;
    private Long commission;

    public Booking(Long accommodationId, String bookingStatus, String paymentStatus, LocalDateTime checkIn, LocalDateTime checkOut, Long guests, Long rentPayment, Long commission) {
        this.accommodationId = accommodationId;
        this.bookingStatus = bookingStatus;
        this.paymentStatus = paymentStatus;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
        this.rentPayment = rentPayment;
        this.commission = commission;
    }

    public Booking() {

    }
}

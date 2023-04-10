package com.almaz.bulbal.model.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String status;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Long guests;

    public Booking(Long accommodationId, String status, LocalDateTime checkIn, LocalDateTime checkOut, Long guests) {
        this.accommodationId = accommodationId;
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
    }

    public Booking() {

    }
}

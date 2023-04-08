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
    private Long amount;
    @JsonIgnore
    @Column(name = "accommodation_id")
    private Long accommodationId;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Booking(Long accommodationId, String status, LocalDateTime startDate, LocalDateTime endDate) {
        this.accommodationId = accommodationId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking() {

    }
}

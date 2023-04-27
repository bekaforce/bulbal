package com.almaz.bulbal.dto.main;


import lombok.Data;

@Data
public class BookBedDto extends BookingDto {
    private Long bedId;
    private Long rentPayment;
    private Long commission;
}

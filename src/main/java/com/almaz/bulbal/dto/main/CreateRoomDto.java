package com.almaz.bulbal.dto.main;

import lombok.Data;

@Data
public class CreateRoomDto {
    private Long accommodation_id;
    private String typeOfAccommodation;
    private Long price;
    private String typeOfBed;
    private Long sizeOfBed;
    private Long amountOfBed;
    private Long pricePerBed;

}

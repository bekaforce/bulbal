package com.almaz.bulbal.dto.main;

import com.almaz.bulbal.model.main.Bed;
import com.almaz.bulbal.model.main.Convenience;
import lombok.Data;

import java.util.List;

@Data
public class AccommodationDto {
    private Long id;
    private Long ownerId;
    private String region;
    private String locality;
    private String typeOfAccommodation;
    private String titleOfAccommodation;
    private String typeOfRoom;
    private String fullDescriptionOfAccommodation;
    private List<Convenience> conveniences;
    private List<Bed> beds;
    private Long price;
    private Long pricePerBed;
}

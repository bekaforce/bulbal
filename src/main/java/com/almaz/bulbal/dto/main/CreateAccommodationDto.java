package com.almaz.bulbal.dto.main;

import com.almaz.bulbal.model.main.Convenience;
import lombok.Data;

import java.util.List;

@Data
public class CreateAccommodationDto {
    private Long ownerId;
    private String region;
    private String locality;
    private String titleOfAccommodation;
    private String fullDescriptionOfAccommodation;
    private List<Convenience> conveniences;
}

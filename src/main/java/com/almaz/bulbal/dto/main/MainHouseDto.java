package com.almaz.bulbal.dto.main;

import com.almaz.bulbal.model.main.Convenience;
import lombok.Data;

import java.util.List;

@Data
public class MainHouseDto {
    private Long id;
    private Long ownerId;
    private String region;
    private String locality;
    private String typeOfRoom;
    private String typeOfHouse;
    private String typeOfBed;
    private String titleOfHouse;
    private String fullDescriptionOfHouse;
    private Integer priceForOnePlace;
    private List<Convenience> conveniences;
//    private String conveniences;
}

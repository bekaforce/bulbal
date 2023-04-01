package com.almaz.bulbal.dto.main;

import lombok.Data;

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
//    private List<Convenience> conveniences;
    private String conveniences;
}

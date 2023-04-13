package com.almaz.bulbal.repository.main;

import java.time.LocalDateTime;

public interface MainPageDto {
    Long getId();
    String getRegion();
    String getLocalityName();
    String getTitleOfAccommodation();
    Double getPrice();
    String getImageFullName();
    LocalDateTime getCreateDate();
}

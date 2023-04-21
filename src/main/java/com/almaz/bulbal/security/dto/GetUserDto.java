package com.almaz.bulbal.security.dto;

import lombok.Data;

public interface GetUserDto {
    Long getId();
    String getName();
    String getDescription();
}

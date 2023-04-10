package com.almaz.bulbal.dto.main;

import lombok.Data;

@Data
public class PageParametersDto {
    private int pageNumber;
    private int pageSize;
    private String sortBy;
}
package com.almaz.bulbal.dto.main;

import lombok.Data;

@Data
public class PageSearchParametersDto {
    private int pageNumber;
    private int pageSize;
    private String sortBy;
    private String locality;
}

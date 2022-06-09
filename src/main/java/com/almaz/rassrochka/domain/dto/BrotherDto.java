package com.almaz.rassrochka.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BrotherDto {
    private Long id;
    private String fullName;
    private String brotherType;
    private String phoneNumber;
    private String address;
    private Long profileId;

}

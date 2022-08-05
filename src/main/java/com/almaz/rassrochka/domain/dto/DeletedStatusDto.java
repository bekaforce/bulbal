package com.almaz.rassrochka.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeletedStatusDto {
    private Long id;
    private Boolean deleted;
}

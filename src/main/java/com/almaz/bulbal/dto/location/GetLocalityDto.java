package com.almaz.bulbal.dto.location;

import com.almaz.bulbal.dto.project.GetNameDto;
import lombok.Data;

@Data
public class GetLocalityDto extends GetNameDto {
    private Long regionId;
}

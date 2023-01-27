package com.example.admin_bulbal.dto.location;

import com.example.admin_bulbal.dto.project.GetNameDto;
import lombok.Data;

@Data
public class GetLocalityDto extends GetNameDto {
    private Long regionId;
}

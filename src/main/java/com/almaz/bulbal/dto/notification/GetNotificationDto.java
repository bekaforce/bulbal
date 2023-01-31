package com.almaz.bulbal.dto.notification;

import com.almaz.bulbal.dto.project.GetNameDto;
import lombok.Data;

@Data
public class GetNotificationDto extends GetNameDto {
    private String title;
    private String text;
}

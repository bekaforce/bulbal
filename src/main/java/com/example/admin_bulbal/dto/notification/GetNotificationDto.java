package com.example.admin_bulbal.dto.notification;

import com.example.admin_bulbal.dto.project.GetNameDto;
import lombok.Data;

@Data
public class GetNotificationDto extends GetNameDto {
    private String title;
    private String text;
}

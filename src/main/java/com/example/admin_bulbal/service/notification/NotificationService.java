package com.example.admin_bulbal.service.notification;

import com.example.admin_bulbal.dto.notification.GetNotificationDto;
import com.example.admin_bulbal.model.notification.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(GetNotificationDto getNotificationDto);
    Notification update(GetNotificationDto getNotificationDto, Long id);
    Notification findById(Long id);
    boolean deleteById(Long id);
    List<Notification> all(Long id);
    Notification setNotification(Notification notification, GetNotificationDto getNotificationDto);
}

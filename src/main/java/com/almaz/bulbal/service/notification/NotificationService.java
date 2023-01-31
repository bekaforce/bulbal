package com.almaz.bulbal.service.notification;

import com.almaz.bulbal.dto.notification.GetNotificationDto;
import com.almaz.bulbal.model.notification.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(GetNotificationDto getNotificationDto);
    Notification update(GetNotificationDto getNotificationDto, Long id);
    Notification findById(Long id);
    boolean deleteById(Long id);
    List<Notification> all();
    Notification setNotification(Notification notification, GetNotificationDto getNotificationDto);
}

package com.almaz.bulbal.service.notification.impl;

import com.almaz.bulbal.dto.notification.GetNotificationDto;
import com.almaz.bulbal.model.notification.Notification;
import com.almaz.bulbal.repository.notification.NotificationRepo;
import com.almaz.bulbal.service.notification.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepo notificationRepo;

    public NotificationServiceImpl(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    @Override
    public Notification save(GetNotificationDto getNotificationDto) {
        Notification notification = new Notification();
        return setNotification(notification, getNotificationDto);
    }

    @Override
    public Notification update(GetNotificationDto getNotificationDto, Long id) {
        Notification notification = findById(id);
        if (notification != null){
            return setNotification(notification, getNotificationDto);
        }
        return null;
    }

    @Override
    public Notification findById(Long id) {
        return notificationRepo.findNotificationById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        Notification notification = findById(id);
        if (notification != null){
            notificationRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Notification> all() {
        return notificationRepo.findAll();
    }

    @Override
    public Notification setNotification(Notification notification, GetNotificationDto getNotificationDto) {
        notification.setName(getNotificationDto.getName());
        notification.setTitle(getNotificationDto.getTitle());
        notification.setText(getNotificationDto.getText());
        return notificationRepo.save(notification);
    }
}

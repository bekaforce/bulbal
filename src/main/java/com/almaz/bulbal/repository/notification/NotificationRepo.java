package com.almaz.bulbal.repository.notification;

import com.almaz.bulbal.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
    Notification findNotificationById(Long id);
}

package com.almaz.bulbal.repository.notification;

import com.almaz.bulbal.model.notification.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

}

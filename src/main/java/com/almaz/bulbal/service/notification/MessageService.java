package com.almaz.bulbal.service.notification;

import com.almaz.bulbal.dto.notification.MessageDto;
import com.almaz.bulbal.model.notification.Message;

import java.util.List;

public interface MessageService {
    Message send(MessageDto messageDto);
    void setMessage(Message message, MessageDto messageDto);

    List<Message> all();
}

package com.almaz.bulbal.service.notification.impl;

import com.almaz.bulbal.dto.notification.MessageDto;
import com.almaz.bulbal.model.notification.Message;
import com.almaz.bulbal.repository.notification.MessageRepo;
import com.almaz.bulbal.service.notification.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepo messageRepo;

    public MessageServiceImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    @Override
    public Message send(MessageDto messageDto) {
        Message message = new Message();
        setMessage(message, messageDto);
        return messageRepo.save(message);
    }

    @Override
    public void setMessage(Message message, MessageDto messageDto) {
        message.setText(messageDto.getText());
        message.setSenderId(messageDto.getSenderId());
        message.setReceiverId(messageDto.getReceiverId());
        message.setSent(LocalDateTime.now(ZoneId.of("Asia/Bishkek")));
    }

    @Override
    public List<Message> all() {
        return messageRepo.findAll();
    }
}

package com.almaz.bulbal.controller.notification;

import com.almaz.bulbal.dto.notification.MessageDto;
import com.almaz.bulbal.model.notification.Message;
import com.almaz.bulbal.service.notification.impl.MessageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final MessageServiceImpl messageService;

    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/send")
    ResponseEntity<?> send(@RequestBody MessageDto messageDto){
        Message message = messageService.send(messageDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    ResponseEntity<?> all(){
        return new ResponseEntity<>(messageService.all(), HttpStatus.OK);
    }
}

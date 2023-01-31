package com.almaz.bulbal.controller.notification;

import com.almaz.bulbal.controller.Url;
import com.almaz.bulbal.dto.notification.GetNotificationDto;
import com.almaz.bulbal.model.notification.Notification;
import com.almaz.bulbal.service.notification.impl.NotificationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = Url.ADMIN_API + Url.NOTIFICATION)
public class NotificationController {
    private final NotificationServiceImpl notificationService;

    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    @DeleteMapping(Url.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = notificationService.deleteById(id);
        return response
                ? new ResponseEntity<>("Notification was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Url.SAVE)
    public ResponseEntity<?> save(@RequestBody GetNotificationDto getNotificationDto){
        Notification response = notificationService.save(getNotificationDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Url.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody GetNotificationDto getNotificationDto, @PathVariable(value = "id") Long id){
        Notification response = notificationService.update(getNotificationDto, id);
        return response != null
                ? new ResponseEntity<>("Notification was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<Notification> response = notificationService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

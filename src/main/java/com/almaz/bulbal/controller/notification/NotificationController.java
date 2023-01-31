package com.example.admin_bulbal.controller.notification;

import com.example.admin_bulbal.controller.Url;
import com.example.admin_bulbal.dto.notification.GetNotificationDto;
import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.location.Region;
import com.example.admin_bulbal.model.notification.Notification;
import com.example.admin_bulbal.service.notification.impl.NotificationServiceImpl;
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

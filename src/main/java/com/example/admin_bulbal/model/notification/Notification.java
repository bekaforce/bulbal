package com.example.admin_bulbal.model.notification;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notification", schema = "bulbal")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_seq")
    @SequenceGenerator(name = "notification_seq", initialValue = 1, allocationSize = 1, sequenceName = "notification_id_seq")
    private Long id;
    private String name;
    private String title;
    private String text;
}

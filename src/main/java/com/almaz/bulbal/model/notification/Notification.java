package com.almaz.bulbal.model.notification;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_seq")
    @SequenceGenerator(name = "notification_seq", initialValue = 1, allocationSize = 1, sequenceName = "notification_id_seq")
    private Long id;
    private String name;
    private String title;
    private String text;
}

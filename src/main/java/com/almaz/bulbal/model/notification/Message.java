package com.almaz.bulbal.model.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "message" )
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    @JsonProperty("sender_id")
    @Column(name = "sender_id")
    private Long senderId;
    @JsonProperty("receiver_id")
    @Column(name = "receiver_id")
    private Long receiverId;
    private LocalDateTime sent;
}

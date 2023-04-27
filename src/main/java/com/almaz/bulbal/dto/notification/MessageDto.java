package com.almaz.bulbal.dto.notification;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class MessageDto {
    @Lob
    private String text;
    private Long senderId;
    private Long receiverId;

}

package com.almaz.bulbal.security.dto;

import com.almaz.bulbal.model.user.Hobby;
import com.almaz.bulbal.model.user.LikeTravel;
import lombok.Data;

import java.util.List;

@Data
public class FormDto {
    private Long userId;
    private String nickName;
    private String name;
    private String liveIn;
    private String language;
    private String contactPerson;
    private String instagramUrl;
    private String twitterUrl;
    private String description;
    private String phoneNumber;
    private List<Hobby> hobbies;
    private List<LikeTravel> travels;
}

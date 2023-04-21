package com.almaz.bulbal.model.main;

import com.almaz.bulbal.model.location.Region;
import com.almaz.bulbal.security.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    private Accommodation accommodation;

    public Comment() {

    }
}

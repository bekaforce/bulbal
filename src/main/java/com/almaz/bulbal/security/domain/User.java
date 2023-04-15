package com.almaz.bulbal.security.domain;

import com.almaz.bulbal.enums.Status;
import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.model.main.Booking;
import com.almaz.bulbal.model.user.Hobby;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data

@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @Column(name = "admin_login")
    private String adminLogin;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", schema = "public", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String otp;
    private String personalPass;
    private String nickName;
    private String name;
    private String liveIn;
    private String language;
    private String contactPerson;
    private String instagramUrl;
    private String twitterUrl;
    private String description;
    private String phoneNumber;
    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private List<Accommodation> accommodation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Booking> bookings;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Hobby> hobbies;


}


package com.almaz.rassrochka.security.domain;

import com.almaz.rassrochka.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data

@Table(name = "users", schema = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(name = "admin_login")
    private String adminLogin;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", schema = "users", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String phoneNumber;
    private LocalDateTime date;


}


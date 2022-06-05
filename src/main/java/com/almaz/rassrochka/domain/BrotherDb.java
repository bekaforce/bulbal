package com.almaz.rassrochka.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brother", schema = "azamat")
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class BrotherDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 5, max = 25)
    @Column(name = "full_name", length = 25)
    private String fullName;

    @NotNull
    @Size(max = 20, min = 3)
    @Column(name = "brother_type", length = 20)
    private String brotherType;

    @NotNull
    @Size(min = 9, max = 15)
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @NotNull
    @Size(min = 9, max = 50)
    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "profile_id")
    private Long profileId;

    @OneToOne
    @JoinColumn (name = "profile_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProfileDb profileDb;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "salesman_login")
    private String salesmanLogin;
}

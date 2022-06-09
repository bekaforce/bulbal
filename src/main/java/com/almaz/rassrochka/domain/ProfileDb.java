package com.almaz.rassrochka.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "profile", schema = "azamat")
public class ProfileDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "full_name", length = 50)
    private String fullName;

    @NotNull
    @Size(min = 14, max = 14)
    @Column(name = "passport_inn", length = 14)
    private String passportInn;

    @NotNull
    @Size(min = 5, max = 15)
    @Column(name = "passport_series", length = 15)
    private String passportSeries;

    @NotNull
    @Size(min = 5, max = 10)
    @Column(name = "passport_date", length = 10)
    private String passportDate;

    @NotNull
    @Size(min = 5, max = 10)
    @Column(name = "passport_department", length = 10)
    private String passportDepartment;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "passport_address", length = 100)
    private String passportAddress;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "work_address", length = 100)
    private String workAddress;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "fact_address", length = 100)
    private String factAddress;

    @NotNull
    @Size(min = 7, max = 25)
    @Column(name = "phone", length = 25)
    private String phone;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "salesman_login")
    private String salesmanLogin;

    public ProfileDb() {

    }
}

package com.almaz.rassrochka.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "device_owner", schema = "public")
public class DeviceOwnerDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(name = "device_owner", length = 15)
    private String deviceOwner;

    @Size(min = 3, max = 20)
    @NotNull
    @Column(name = "device_owner_ip", length = 20)
    private String deviceOwnerIp;

    @NotNull
    @Column(name = "device_id")
    private Long deviceId;

    @OneToOne
    @JoinColumn (name = "device_id", referencedColumnName = "id", insertable = false, updatable = false)
    private DeviceDb deviceDb;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "salesman_login")
    private String salesmanLogin;

    public DeviceOwnerDb() {

    }
}

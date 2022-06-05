package com.almaz.rassrochka.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "device_owner", schema = "azamat")
public class DeviceOwnerDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "device_owner")
    private String deviceOwner;

    @Column(name = "device_owner_ip")
    private String deviceOwnerIp;

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

package com.almaz.rassrochka.domain;

import com.almaz.rassrochka.enums.StatusType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "device", schema = "public")

public class DeviceDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "device_model", length = 30)
    private String deviceModel;

    @NotNull
    @Size(min = 3)
    @Column(name = "cloud_login", length = 50)
    private String cloudLogin;

    @NotNull
    @Size(min = 3)
    @Column(name = "cloud_pass", length = 50)
    private String cloudPass;

    @NotNull
    @Size(min = 2)
    @Column(name = "device_memory", length = 10)
    private String deviceMemory;

    @NotNull
    @Column(name = "device_price", length = 6)
    private Integer devicePrice;

    @NotNull
    @Column(name = "zero_payment", length = 7)
    private Integer zeroPayment;

    @NotNull
    @Column(name = "payment_type", length = 50)
    private String paymentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private StatusType statusType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private List<MonthCreditDb> monthCreditDb;

    @NotNull
    @Size(min = 12, max = 20)
    @Column(name = "device_imei", length = 20)
    private String deviceImei;

    @Column(name = "profile_id")
    private Long profileId;

    @OneToOne
    @JoinColumn (name = "profile_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProfileDb profileDb;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "salesman_login")
    private String salesmanLogin;


    public DeviceDb() {

    }
}

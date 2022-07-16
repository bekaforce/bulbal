package com.almaz.rassrochka.domain;

import com.almaz.rassrochka.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "credit", schema = "azamat")
public class CreditDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "zero_payment", length = 7)
    private Integer zeroPayment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_id", referencedColumnName = "id")
    private List<MonthCreditDb> monthCreditDb;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private StatusType statusType;

    @Column(name = "device_id")
    private Long deviceId;

    @OneToOne
    @JoinColumn (name = "device_id", referencedColumnName = "id", insertable = false, updatable = false)
    private DeviceDb deviceDb;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "salesman_login")
    private String salesmanLogin;




    public CreditDb() {

    }
}

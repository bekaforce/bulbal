package com.almaz.rassrochka.domain;

import com.almaz.rassrochka.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "month_credit", schema = "public")
public class MonthCreditDb {
    @Id
    @JsonIgnore
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "count_month")
    private Integer countMonth;

    @Column(name = "debt_report")
    private Integer debtReport;

    @Column(name = "payment_type", length = 50)
    private String paymentType;

    @Column(name = "pay_date")
    private LocalDate payDate;

    @Column(name = "debt")
    private Double debt;

    @Column(name = "debt_closed_date")
    private LocalDateTime debtClosedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private StatusType statusType;

    @Column(name = "comment")
    private String comment;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "salesman_login")
    private String salesmanLogin;

    public MonthCreditDb() {

    }

}

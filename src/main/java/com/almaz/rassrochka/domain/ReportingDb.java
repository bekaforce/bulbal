package com.almaz.rassrochka.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report", schema = "public")
public class ReportingDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "device_id")
    private Long deviceId;
    @Column(name = "count_month")
    private Integer countMonth;

    @Column(name = "debt_report")
    private Integer debtReport;

    @Column(name = "payment_type", length = 50)
    private String paymentType;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "salesman_login")
    private String salesmanLogin;

}

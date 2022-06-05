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
@Table(name = "credit", schema = "azamat")
public class CreditDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 2, max = 6)
    @Column(name = "device_price", length = 6)
    private Integer devicePrice;

    @Size(min = 2, max = 6)
    @Column(name = "zero_payment")
    private Integer zeroPayment;

    @Column(name = "zero_payment_date")
    private LocalDateTime zeroPaymentDate;

    @Size(min = 2, max = 6)
    @Column(name = "first_payment")
    private Integer firstPayment;

    @Column(name = "first_status")
    private Boolean firstStatus;

    @Column(name = "first_payment_date")
    private LocalDateTime firstPaymentDate;

    @Column(name = "second_payment")
    private Integer secondPayment;

    @Column(name = "second_status")
    private Boolean secondStatus;

    @Column(name = "second_payment_date")
    private LocalDateTime secondPaymentDate;

    @Column(name = "third_payment")
    private Integer thirdPayment;

    @Column(name = "third_status")
    private Boolean thirdStatus;

    @Column(name = "third_payment_date")
    private LocalDateTime thirdPaymentDate;

    @NotNull
    @Column(name = "percent_first_month")
    private Double percentFirstMonth;

    @Column(name = "percent_second_month")
    private Double percentSecondMonth;

    @Column(name = "percent_third_month")
    private Double percentThirdMonth;

    @Column(name = "main_status")
    private Boolean mainStatus;

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

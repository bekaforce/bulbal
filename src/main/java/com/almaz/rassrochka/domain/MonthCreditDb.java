package com.almaz.rassrochka.domain;

import com.almaz.rassrochka.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "month_credit", schema = "azamat")
public class MonthCreditDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "credit_id")
    private Long creditId;

    @Column(name = "count_month")
    private Integer countMonth;

    @Column(name = "percent")
    private Double percent;

    @Column(name = "debt")
    private Double debt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private StatusType statusType;

    @Column(name = "comment")
    private String comment;

    public MonthCreditDb() {

    }

}

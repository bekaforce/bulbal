package com.almaz.bulbal.model.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "convenience")
public class Convenience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "convenience_seq", initialValue = 1, allocationSize = 1, sequenceName = "convenience_id_seq")
    private Long id;

    @Column(name = "convenience_name", nullable = false)
    private String convenienceName;

    @ManyToOne
    @JoinColumn(name = "mainHouse_id")
    @JsonIgnore
    private MainHouse mainHouse;
}

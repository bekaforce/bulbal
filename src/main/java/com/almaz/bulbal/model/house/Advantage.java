package com.almaz.bulbal.model.house;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "advantage")
public class Advantage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advantage_seq")
    @SequenceGenerator(name = "advantage_seq", initialValue = 1, allocationSize = 1, sequenceName = "advantage_id_seq")
    private Long id;
    private String name;

    public Advantage(String name) {
        this.name = name;
    }

    public Advantage() {

    }
}

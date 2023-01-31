package com.almaz.bulbal.model.house;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type_of_house")
public class TypeOfHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfHouse_seq")
    @SequenceGenerator(name = "typeOfHouse_seq", initialValue = 1, allocationSize = 1, sequenceName = "typeOfHouse_id_seq")
    private Long id;
    private String name;
}

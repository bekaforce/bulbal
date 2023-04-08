package com.almaz.bulbal.model.house;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type_of_bed")
public class TypeOfBed {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfBed_seq")
    @SequenceGenerator(name = "typeOfBed_seq", initialValue = 1, allocationSize = 1, sequenceName = "typeOfBed_id_seq")
    private Long id;
    private String name;
//    private Long value;
}

package com.almaz.bulbal.model.house;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type_of_accommodation")
public class TypeOfAccommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfAccommodation_seq")
    @SequenceGenerator(name = "typeOfAccommodation_seq", initialValue = 1, allocationSize = 1, sequenceName = "typeOfAccommodation_id_seq")
    private Long id;
    private String name;
}

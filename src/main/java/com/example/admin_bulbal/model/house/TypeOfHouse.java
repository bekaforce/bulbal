package com.example.admin_bulbal.model.house;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "type_of_house", schema = "bulbal")
public class TypeOfHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfHouse_seq")
    @SequenceGenerator(name = "typeOfHouse_seq", initialValue = 1, allocationSize = 1, sequenceName = "typeOfHouse_id_seq")
    private Long id;
    private String name;
}

package com.example.admin_bulbal.model.house;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "type_of_bed", schema = "bulbal")
public class TypeOfBed {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfBed_seq")
    @SequenceGenerator(name = "typeOfBed_seq", initialValue = 1, allocationSize = 1, sequenceName = "typeOfBed_id_seq")
    private Long id;
    private String name;
    private Long value;
}

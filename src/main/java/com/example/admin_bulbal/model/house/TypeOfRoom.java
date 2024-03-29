package com.example.admin_bulbal.model.house;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "type_of_room", schema = "bulbal")
public class TypeOfRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfRoom_seq")
    @SequenceGenerator(name = "typeOfRoom_seq", initialValue = 1, allocationSize = 1, sequenceName = "typeOfRoom_id_seq")
    private Long id;
    private String name;


}

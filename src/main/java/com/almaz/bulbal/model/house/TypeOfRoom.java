package com.almaz.bulbal.model.house;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type_of_room")
public class TypeOfRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfRoom_seq")
    @SequenceGenerator(name = "typeOfRoom_seq", initialValue = 1, allocationSize = 1, sequenceName = "typeOfRoom_id_seq")
    private Long id;
    private String name;
    private Long size;


}

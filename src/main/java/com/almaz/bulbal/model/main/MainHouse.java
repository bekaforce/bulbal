package com.almaz.bulbal.model.main;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "main_house")
public class MainHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "type_of_house", nullable = false)
    private String typeOfHouse;

//    @ManyToOne
//    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Long ownerId;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "locality_name", nullable = false)
    private String locality;

    @Column(name = "type_of_room", nullable = false)
    private String typeOfRoom;

    @Column(name = "type_of_bed", nullable = false)
    private String typeOfBed;

    @Column(name = "title_of_house", nullable = false)
    private String titleOfHouse;

    @Column(name = "full_description_of_house", nullable = false)
    private String fullDescriptionOfHouse;

    @Column(name = "price_for_one_place", nullable = false)
    private Integer priceForOnePlace;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
//    @JoinColumn(name = "mainHouse_id")
//    private List<Convenience> conveniences;

    private String conveniences;
}

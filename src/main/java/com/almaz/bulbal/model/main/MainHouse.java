package com.almaz.bulbal.model.main;

import com.almaz.bulbal.security.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "main_house")
public class MainHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @JsonProperty("id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type_of_house", nullable = false)
    private String typeOfHouse;

    @JsonProperty("owner_id")
    @Column(name = "owner_id")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mainHouse_id", referencedColumnName = "id")
    private List<Convenience> conveniences;

    public MainHouse() {

    }

}

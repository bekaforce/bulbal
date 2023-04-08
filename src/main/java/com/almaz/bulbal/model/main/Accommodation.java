package com.almaz.bulbal.model.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @JsonProperty("id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type_of_accommodation", nullable = false)
    private String typeOfAccommodation;

    @JsonProperty("owner_id")
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "locality_name", nullable = false)
    private String locality;

    @Column(name = "title_of_accommodation", nullable = false)
    private String titleOfAccommodation;

    @Column(name = "full_description_of_accommodation", nullable = false)
    private String fullDescriptionOfAccommodation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    private List<Convenience> conveniences;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    private List<Bed> beds;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.REMOVE)
    private List<Image> images;
    private LocalDateTime createDate;

    @Column(name = "price")
    private Long price;

    public Accommodation() {

    }

}
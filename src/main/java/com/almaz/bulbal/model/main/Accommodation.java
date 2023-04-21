package com.almaz.bulbal.model.main;

import com.almaz.bulbal.model.location.Region;
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

    @Column(name = "type_of_accommodation")
    private String typeOfAccommodation;

    @JsonProperty("owner_id")
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "locality_name", nullable = false)
    private String locality;

    @Column(name = "address", nullable = false)
    private String address;

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

    @JsonIgnore
    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.REMOVE)
    private List<Image> images;
    private LocalDateTime createDate;

    @Column(name = "price")
    private Long price;

    @Column(name = "pricePerBed")
    private Long pricePerBed;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

//    @ManyToOne
//    @JoinColumn(name = "residence_id", referencedColumnName = "id")
//    private Residence residence;

    public Accommodation() {

    }

}

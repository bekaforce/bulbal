package com.almaz.bulbal.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "locality")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locality_seq")
    @SequenceGenerator(name = "locality_seq", initialValue = 1, allocationSize = 1, sequenceName = "locality_id_seq")
    private Long id;
    private String name;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;
}

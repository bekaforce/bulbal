package com.almaz.bulbal.model.location;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
    @SequenceGenerator(name = "region_seq", initialValue = 1, allocationSize = 1, sequenceName = "region_id_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "region", cascade = CascadeType.REMOVE)
    private List<Locality> localities;
}

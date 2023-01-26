package com.example.admin_bulbal.model.location;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "region", schema = "bulbal")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
    @SequenceGenerator(name = "region_seq", initialValue = 1, allocationSize = 1, sequenceName = "region_id_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "region", cascade = CascadeType.REMOVE)
    private List<Locality> localities;
}

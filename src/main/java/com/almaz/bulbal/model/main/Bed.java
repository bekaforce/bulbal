package com.almaz.bulbal.model.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Table(name = "bed")
public class Bed {
    @Id
    @JsonIgnore
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size", nullable = false)
    private Long size;

    @JsonIgnore
    @Column(name = "accommodation_id")
    private Long accommodationId;

    public Bed() {

    }

    public Bed(Long id, String name, Long size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }
}

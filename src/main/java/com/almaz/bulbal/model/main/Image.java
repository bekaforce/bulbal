package com.almaz.bulbal.model.main;

import com.almaz.bulbal.security.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Table(name = "image")
public class Image {
    @Id
    @JsonIgnore
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fileName", nullable = false)
    private String fileName;

    private Boolean main;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "accommodation_id", referencedColumnName = "id")
    private Accommodation accommodation;

    public Image(String fileName, Accommodation accommodation) {
        this.fileName = fileName;
        this.accommodation = accommodation;
    }


    public Image() {

    }
}

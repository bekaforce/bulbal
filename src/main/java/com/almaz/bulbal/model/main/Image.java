package com.almaz.bulbal.model.main;

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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "mainHouse_id", referencedColumnName = "id")
    private MainHouse mainHouse;

    public Image(String fileName, MainHouse mainHouse) {
        this.fileName = fileName;
        this.mainHouse = mainHouse;
    }

    public Image() {

    }
}

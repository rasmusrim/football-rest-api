package com.rasmusrim.football.rest.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Color {

    public Color() {
    }

    public Color(String colorName) {
        this.colorName = colorName;
    }

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String colorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}

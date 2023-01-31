package com.project.drone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Medication {

    @JsonProperty
    private String name;
    @JsonProperty
    private float weight;

    @Id
    private String code;

    public Medication() {
    }

    public Medication(String name, float weight, String code) {
        this.name = name;
        this.weight = weight;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

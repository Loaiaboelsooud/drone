package com.project.drone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DroneModel {
    @Id
    private int id;
    @NotNull
    @JsonProperty
    private String name;
    @NotNull
    @JsonProperty
    private String maxWeight;
public DroneModel(){}
    public DroneModel(int id, String name, String maxWeight) {
        super();
        this.id = id;
        this.name = name;
        this.maxWeight = maxWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DroneModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxWeight='" + maxWeight + '\'' +
                '}';
    }
}

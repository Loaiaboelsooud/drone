package com.project.drone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.drone.enums.DroneState;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Drone {
    @Id
    private int serialNumber;
    @ManyToOne
    @JsonProperty
    private DroneModel droneModel;
    @JsonProperty
    private float batteryCapacity;
    @JsonProperty
    private DroneState state;

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getDroneModel() {
        return droneModel;
    }

    public void setDroneModel(DroneModel droneModel) {
        this.droneModel = droneModel;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }
}

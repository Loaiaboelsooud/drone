package com.project.drone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.drone.enums.DroneState;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialNumber;
    @ManyToOne
    @JsonProperty
    private DroneModel droneModel;
    @JsonProperty
    private int batteryCapacity;
    @JsonProperty
    private DroneState state;
    @JsonProperty
    private Date shippingTime;


    public Drone() {
    }

    public Drone(DroneModel droneModel) {
        this.droneModel = droneModel;
        this.batteryCapacity = 100;
        this.state = DroneState.IDLE;
    }

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

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }
}

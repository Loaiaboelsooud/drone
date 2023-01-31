package com.project.drone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.drone.enums.DroneState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @OneToMany
    @JsonProperty
    private List<Medication> medications;


    public Drone() {
    }

    public Drone(DroneModel droneModel) {
        this.droneModel = droneModel;
        this.batteryCapacity = 100;
        this.state = DroneState.IDLE;
        this.medications= new ArrayList<>();
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

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
}

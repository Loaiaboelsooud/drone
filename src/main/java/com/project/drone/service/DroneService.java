package com.project.drone.service;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneModel;
import com.project.drone.model.Medication;

import java.util.List;

public interface DroneService {
    List<Drone> findAll();

    Drone init(float maxWeight);

    Drone findSuitableDrone(float maxWeight);

    List<Drone> findAvailableDrones();

    Integer getBatteryLevel(int serialNumber);

    List<Medication> findMedications(int serialNumber);
}

package com.project.drone.service;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneModel;

import java.util.List;

public interface DroneService {
    List<Drone> findAll();

    Drone init(float maxWeight);

    Drone findSuitableDrone(float maxWeight);
}

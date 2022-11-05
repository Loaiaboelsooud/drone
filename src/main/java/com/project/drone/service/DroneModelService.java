package com.project.drone.service;

import com.project.drone.model.DroneModel;

import java.util.List;

public interface DroneModelService {
    List<DroneModel> findAll();
    DroneModel getSuitableDroneModel(float maxWeight);
}

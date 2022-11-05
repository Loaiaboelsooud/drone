package com.project.drone.service.impl;

import com.project.drone.dao.DroneDao;
import com.project.drone.model.Drone;
import com.project.drone.service.DroneModelService;
import com.project.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneServiceImpl implements DroneService {
    @Autowired
    private DroneDao droneDao;
    @Autowired
    private DroneModelService droneModelService;

    @Override
    public void init(float maxWeight) {
        droneModelService.getSuitableDroneModel(maxWeight);
    }
}

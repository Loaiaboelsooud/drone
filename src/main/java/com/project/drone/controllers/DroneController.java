package com.project.drone.controllers;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneModel;
import com.project.drone.service.DroneModelService;
import com.project.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DroneController {
    @Autowired
    private DroneModelService droneModelService;
    @Autowired
    private DroneService droneService;

    @GetMapping("/droneModel")
    public List<DroneModel> getDronesModel() {
        return droneModelService.findAll();

    }

    @PostMapping("/drone")
    public void saveDrone(@RequestBody float maxWeight) {
        droneService.init(maxWeight);

    }
}

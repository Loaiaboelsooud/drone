package com.project.drone.controllers;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneModel;
import com.project.drone.model.Medication;
import com.project.drone.service.DroneModelService;
import com.project.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drone")
public class DroneController {
    @Autowired
    private DroneModelService droneModelService;
    @Autowired
    private DroneService droneService;

    @GetMapping("/droneModel")
    public List<DroneModel> getDronesModel() {
        return droneModelService.findAll();
    }

    @GetMapping("/findAll")
    public List<Drone> getDrones() {
        return droneService.findAll();

    }

    @GetMapping("{serialNumber}/battery")
    public Integer getBatteryCapacity(@PathVariable int serialNumber) {
        return droneService.getBatteryLevel(serialNumber);
    }

    @GetMapping("/available")
    public List<Drone> findAvailableDrones() {
        return droneService.findAvailableDrones();
    }

    @GetMapping("/{serialNumber}/medications")
    public List<Medication> findMedications(@PathVariable int serialNumber) {
        return droneService.findMedications(serialNumber);
    }

    @PostMapping("/init/{maxWeight}")
    public Drone createNewDrone(@PathVariable float maxWeight) {
        return droneService.init(maxWeight);
    }
}
package com.project.drone.controllers;

import com.project.drone.model.Medication;
import com.project.drone.service.DroneModelService;
import com.project.drone.service.DroneService;
import com.project.drone.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medication")
public class MedicationController {

    @Autowired
    private DroneModelService droneModelService;

    @Autowired
    private DroneService droneService;

    @Autowired
    private MedicationService medicationService;

    @PostMapping("/load")
    public Medication loadMedication(@RequestParam(value="name", required=true)  String name,
                                     @RequestParam (value="weight", required=true) float weight,
                                     @RequestParam(value="code", required=true)  String code) {
        return medicationService.loadMedication(name, weight, code);
    }
}
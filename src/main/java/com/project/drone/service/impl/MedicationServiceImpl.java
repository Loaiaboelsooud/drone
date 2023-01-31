package com.project.drone.service.impl;

import com.project.drone.dao.DroneDao;
import com.project.drone.dao.MedicationDao;
import com.project.drone.enums.DroneState;
import com.project.drone.model.Drone;
import com.project.drone.model.Medication;
import com.project.drone.service.DroneService;
import com.project.drone.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private DroneDao droneDao;

    @Autowired
    private DroneService droneService;

    @Autowired
    private MedicationDao medicationDao;

    @Override
    public List<Medication> findAll() {
        return medicationDao.findAll();
    }

    @Override
    public Medication loadMedication(String name, float weight, String code) {
        Medication medication = new Medication(name, weight, code);

        Drone drone = droneService.findSuitableDrone(medication.getWeight());
        if (drone != null) {
            drone.setState(DroneState.LOADING);
            drone.setShippingTime(new Date());
            drone.getMedications().add(medication);
            medicationDao.save(medication);
        }
        return medication;
    }
}
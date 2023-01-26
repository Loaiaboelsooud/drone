package com.project.drone.service.impl;

import com.project.drone.dao.DroneDao;
import com.project.drone.enums.DroneState;
import com.project.drone.model.Drone;
import com.project.drone.model.DroneModel;
import com.project.drone.service.DroneModelService;
import com.project.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {
    @Autowired
    private DroneDao droneDao;
    @Autowired
    private DroneModelService droneModelService;

    @Override
    public List<Drone> findAll() {
        return droneDao.findAll();
    }

    @Override
    public Drone init(float maxWeight) {
        DroneModel droneModel = droneModelService.findByMaxWeight(maxWeight);
        if (droneModel != null) {
            Drone drone = new Drone(droneModel);
            return droneDao.save(drone);
        }
        return null;
    }

    @Override
    public Drone findSuitableDrone(float maxWeight) {
        List<Drone> droneList = droneDao.findAll();
        return droneList.stream().filter(drone -> drone.getDroneModel().getMaxWeight() >= maxWeight &&
                drone.getBatteryCapacity() > 25 &&
                DroneState.IDLE.equals(drone.getState())).findFirst().orElse(null);
    }
}

package com.project.drone.service.impl;

import com.project.drone.dao.DroneModelDao;
import com.project.drone.model.DroneModel;
import com.project.drone.service.DroneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneModelServiceImpl implements DroneModelService {
    @Autowired
    private DroneModelDao droneModelDao;

    @Override
    public List<DroneModel> findAll() {
        return droneModelDao.findAll();
    }
    @Override
    public DroneModel getSuitableDroneModel(float maxWeight) {
        return droneModelDao.findByMaxWeight(maxWeight);
    }
}

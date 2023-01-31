package com.project.drone.service.impl;

import com.project.drone.dao.DroneDao;
import com.project.drone.enums.DroneState;
import com.project.drone.model.Drone;
import com.project.drone.model.DroneModel;
import com.project.drone.model.Medication;
import com.project.drone.service.DroneModelService;
import com.project.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class DroneServiceImpl implements DroneService {
    public static final int MAX_BATTERY_CAPACITY = 100;
    public static final int MIN_BATTERY_CAPACITY = 25;

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
        return droneList.stream().filter(drone ->
                        drone.getDroneModel().getMaxWeight() >= maxWeight + getDroneMedicationsWeight(drone) &&
                                drone.getBatteryCapacity() > 25 &&
                                (DroneState.IDLE.equals(drone.getState())
                                        || DroneState.LOADING.equals(drone.getState())))
                .findFirst().orElse(null);
    }

    @Override
    public List<Drone> findAvailableDrones() {
        List<Drone> droneList = droneDao.findAll();
        return droneList.stream().filter(drone -> drone.getBatteryCapacity() > MIN_BATTERY_CAPACITY &&
                        (DroneState.IDLE.equals(drone.getState())
                                || DroneState.LOADING.equals(drone.getState())))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getBatteryLevel(int serialNumber) {
        Drone drone = droneDao.findBySerialNumber(serialNumber);
        if (drone != null) {
            return drone.getBatteryCapacity();
        }
        return null;
    }

    @Override
    public List<Medication> findMedications(int serialNumber) {
        Drone drone = droneDao.findBySerialNumber(serialNumber);
        if (drone != null) {
            return drone.getMedications();
        }
        return null;
    }

    private float getDroneMedicationsWeight(Drone drone) {
        float medicationWeights = 0;
        for (Medication medication : drone.getMedications()) {
            medicationWeights += medication.getWeight();
        }
        return medicationWeights;
    }

    @Scheduled(fixedRate = 60000)
    public void updateDroneStatus() {
        List<Drone> drones = droneDao.findAll().stream().
                filter(drone -> !DroneState.IDLE.equals(drone.getState())).collect(Collectors.toList());

        for (Drone drone : drones) {
            long date = new Date().getTime() - drone.getShippingTime().getTime();
            int diffInMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(date);
            int currentBatteryCapacity = drone.getBatteryCapacity();

            switch (diffInMinutes) {
                case 5:
                    drone.setState(DroneState.LOADED);
                    drone.setBatteryCapacity(currentBatteryCapacity - 5);
                    break;
                case 10:
                    drone.setState(DroneState.DELIVERING);
                    drone.setBatteryCapacity(currentBatteryCapacity - 5);
                    break;
                case 15:
                    drone.setState(DroneState.DELIVERED);
                    drone.setBatteryCapacity(currentBatteryCapacity - 5);
                    break;
                case 20:
                    drone.setState(DroneState.RETURNING);
                    drone.setMedications(new ArrayList<>());
                    drone.setBatteryCapacity(currentBatteryCapacity - 5);
                    break;
                case 25:
                    drone.setState(DroneState.IDLE);
                    drone.setBatteryCapacity(currentBatteryCapacity - 5);
                    drone.setShippingTime(null);
                    break;
                default:
                    break;
            }
            System.out.println("Drone Serial Number " + drone.getSerialNumber() +
                    " State: " + drone.getState().toString() +
                    " battery capacity " + drone.getBatteryCapacity() +
                    " difference in minutes " + diffInMinutes);
            droneDao.save(drone);
        }
    }

    @Scheduled(fixedRate = 10000)
    public void rechargeDrones() {
        List<Drone> drones = droneDao.findAll().stream().
                filter(drone -> DroneState.IDLE.equals(drone.getState())).collect(Collectors.toList());
        int batteryCapacity;
        for (Drone drone : drones) {
            batteryCapacity = drone.getBatteryCapacity();
            if (batteryCapacity < MAX_BATTERY_CAPACITY) {
                drone.setBatteryCapacity(batteryCapacity + 1);
                droneDao.save(drone);
            }
        }
    }
}

package com.project.drone.dao;

import com.project.drone.model.Drone;
import com.project.drone.model.DroneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneDao extends JpaRepository<Drone,Integer> {
    Drone findBySerialNumber(int serialNumber);
}

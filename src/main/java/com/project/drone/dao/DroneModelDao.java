package com.project.drone.dao;

import com.project.drone.model.DroneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneModelDao extends JpaRepository<DroneModel, Integer> {
    DroneModel findByMaxWeight(float maxWeight);
}

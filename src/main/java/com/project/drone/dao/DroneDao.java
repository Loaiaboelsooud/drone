package com.project.drone.dao;

import com.project.drone.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneDao extends JpaRepository<Drone,Integer> {
}

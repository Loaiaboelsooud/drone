package com.project.drone.dao;

import com.project.drone.model.DroneModel;
import com.project.drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationDao extends JpaRepository<Medication, Integer> {
}

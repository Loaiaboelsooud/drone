package com.project.drone.service;

import com.project.drone.model.Medication;

import java.util.List;

public interface MedicationService {

    List<Medication> findAll();

    Medication loadMedication(String name, float weight, String code);
}
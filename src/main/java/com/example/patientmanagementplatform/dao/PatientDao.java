package com.example.patientmanagementplatform.dao;

import com.example.patientmanagementplatform.model.Patient;

import java.util.Map;


public interface PatientDao {
    Map<Integer, Patient> loadAllPatients();
    void saveAllPatients(Map<Integer, Patient> patients);

}

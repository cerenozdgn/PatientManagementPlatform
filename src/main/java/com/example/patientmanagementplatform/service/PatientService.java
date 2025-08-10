package com.example.patientmanagementplatform.service;
import com.example.patientmanagementplatform.dao.PatientDao;
import com.example.patientmanagementplatform.model.Patient;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PatientService {
    private final Map<Integer,Patient> patientMap;
    private final PatientDao dao;


    public PatientService(PatientDao dao) {
        this.dao = dao;
        this.patientMap=dao.loadAllPatients();
    }
    public List<Patient> getAll(){
        return new ArrayList<>(patientMap.values());
    }
    public Optional<Object> getById(int id){
        return Optional.ofNullable(patientMap.get(id));
        //ıd yoksa hata fırlatcak kayıt bulunamadı

    }

    public void addPatient(Patient p){
        if (patientMap.containsKey(p.getId())){
            throw new IllegalStateException("ID zaten var: "+ p.getId());
            //ID boşsa eklemek istediğiniz ıd giriniz diye hata at
        }
        patientMap.put(p.getId(),p);
        dao.saveAllPatients(patientMap);
    }
    public void updatePatients(int id, Patient updated){
        if (!patientMap.containsKey(id)){
            throw new NoSuchElementException("Hasta bulunamadı: " + id);
            //ID boşsa eklemek istediğiniz ıd giriniz diye hata at
        }
        updated.setId(id);
        patientMap.put(id,updated);
        dao.saveAllPatients(patientMap);
    }
    public void deletePatient(int id){
        if (patientMap.remove(id)==null){
            throw new NoSuchElementException("Hasta bulunamadı: " +id);
        }
        dao.saveAllPatients(patientMap);
    }

}

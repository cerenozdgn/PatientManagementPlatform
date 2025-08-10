package com.example.patientmanagementplatform.controller;

import com.example.patientmanagementplatform.model.Patient;
import com.example.patientmanagementplatform.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;

    public PatientController(PatientService service) {
        this.service=service;
    }
    @GetMapping
    public List<Patient> all(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> one(@PathVariable int id){
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient p){
        service.addPatient(p);
        return ResponseEntity.created(URI.create("/patients/" + p.getId())).body(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable int id,@RequestBody Patient p){
        service.updatePatients(id,p);
        return ResponseEntity.ok(p);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable int id){
        service.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}

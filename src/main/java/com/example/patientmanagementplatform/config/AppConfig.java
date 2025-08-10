package com.example.patientmanagementplatform.config;

import com.example.patientmanagementplatform.dao.FilePatientDao;
import com.example.patientmanagementplatform.dao.PatientDao;
import com.example.patientmanagementplatform.service.PatientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PatientDao patientDao(@Value("${patients.file:patients.txt}") String path) {
        return new FilePatientDao(path);
    }

    @Bean
    public PatientService patientService(PatientDao patientDao) {
        return new PatientService(patientDao);
    }
}

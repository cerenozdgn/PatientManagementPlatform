package com.example.patientmanagementplatform.dao;

import com.example.patientmanagementplatform.model.Patient;
import com.example.patientmanagementplatform.util.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class FilePatientDao implements PatientDao{
    private final Path path;

    public FilePatientDao(String filePath) {
        this.path = Paths.get(filePath);
        FileUtils.ensureFileExists(filePath);
    }
    @Override
    public Map<Integer, Patient> loadAllPatients() {
        Map<Integer, Patient> patients = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue; // boş/yorum
                try {
                    Patient p = Patient.fromString(line); // CSV bekler
                    patients.put(p.getId(), p);
                } catch (IllegalArgumentException ex) {
                    if (!"skip".equalsIgnoreCase(ex.getMessage())) {
                        System.err.println("Satır okunamadı: " + line + " | " + ex.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okunurken hata: " + e.getMessage());
        }
        return patients;
    }

    @Override
    public void saveAllPatients(Map<Integer, Patient> patients) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                path, StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
            for (Patient p : patients.values()) {
                writer.write(p.toString()); // CSV
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Dosya yazılırken hata: " + e.getMessage());
        }
    }
}
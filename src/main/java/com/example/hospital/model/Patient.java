package com.example.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;

    private LocalDate dateOfBirth;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;

    public Patient() {}

    public Patient(Long patientId, String name, LocalDate dateOfBirth, com.example.hospital.model.Employee admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    // Getters y setters

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public com.example.hospital.model.Employee getAdmittedBy() { return admittedBy; }
    public void setAdmittedBy(com.example.hospital.model.Employee admittedBy) { this.admittedBy = admittedBy; }
}

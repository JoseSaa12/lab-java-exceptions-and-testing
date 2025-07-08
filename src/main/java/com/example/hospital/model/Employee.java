package com.example.hospital.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

    @Id
    private Long employeeId;

    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonManagedReference
    @OneToMany(mappedBy = "admittedBy")
    private List<com.example.hospital.model.Patient> patients;

    public enum Status {
        ON_CALL, ON, OFF
    }

    // Getters y setters

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public List<com.example.hospital.model.Patient> getPatients() { return patients; }
    public void setPatients(List<com.example.hospital.model.Patient> patients) { this.patients = patients; }
}

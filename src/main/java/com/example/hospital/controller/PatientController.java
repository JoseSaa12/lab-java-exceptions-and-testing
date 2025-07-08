package com.example.hospital.controller;

import com.example.hospital.exception.PatientNotFoundException;
import com.example.hospital.model.Employee;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository repository;

    public PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Patient> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return repository.save(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient with ID " + id + " not found"));
    }


        @GetMapping("/dob")
    public List<Patient> getByDateRange(@RequestParam String start, @RequestParam String end) {
        return repository.findByDateOfBirthBetween(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/department/{department}")
    public List<Patient> getByDoctorDepartment(@PathVariable String department) {
        return repository.findByAdmittedBy_Department(department);
    }

    @GetMapping("/doctor/status/OFF")
    public List<Patient> getByDoctorStatusOff() {
        return repository.findByAdmittedBy_Status(Employee.Status.OFF);
    }
}

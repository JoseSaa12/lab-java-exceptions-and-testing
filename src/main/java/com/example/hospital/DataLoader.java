package com.example.hospital;

import com.example.hospital.model.Employee;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.EmployeeRepository;
import com.example.hospital.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepo;
    private final PatientRepository patientRepo;

    public DataLoader(EmployeeRepository e, PatientRepository p) {
        this.employeeRepo = e;
        this.patientRepo = p;
    }

    @Override
    public void run(String... args) {
        var e1 = new Employee(); e1.setEmployeeId(356712L); e1.setDepartment("cardiology"); e1.setName("Alonso Flores"); e1.setStatus(Employee.Status.ON_CALL);
        var e2 = new Employee(); e2.setEmployeeId(564134L); e2.setDepartment("immunology"); e2.setName("Sam Ortega"); e2.setStatus(Employee.Status.ON);
        var e3 = new Employee(); e3.setEmployeeId(761527L); e3.setDepartment("cardiology"); e3.setName("German Ruiz"); e3.setStatus(Employee.Status.OFF);
        var e4 = new Employee(); e4.setEmployeeId(166552L); e4.setDepartment("pulmonary"); e4.setName("Maria Lin"); e4.setStatus(Employee.Status.ON);
        var e5 = new Employee(); e5.setEmployeeId(156545L); e5.setDepartment("orthopaedic"); e5.setName("Paolo Rodriguez"); e5.setStatus(Employee.Status.ON_CALL);
        var e6 = new Employee(); e6.setEmployeeId(172456L); e6.setDepartment("psychiatric"); e6.setName("John Paul Armes"); e6.setStatus(Employee.Status.OFF);

        employeeRepo.saveAll(List.of(e1, e2, e3, e4, e5, e6));

        patientRepo.save(new Patient(1L, "Jaime Jordan", LocalDate.of(1984, 3, 2), e2));
        patientRepo.save(new Patient(2L, "Marian Garcia", LocalDate.of(1972, 1, 12), e2));
        patientRepo.save(new Patient(3L, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), e1));
        patientRepo.save(new Patient(4L, "Steve McDuck", LocalDate.of(1931, 11, 10), e3));
        patientRepo.save(new Patient(5L, "Marian Garcia", LocalDate.of(1999, 2, 15), e6));
    }
}

package com.example.hospital;

import com.example.hospital.controller.PatientController;
import com.example.hospital.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientRepository repository;

    @Test
    public void testGetAllPatients() throws Exception {
        mockMvc.perform(get("/patients"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPatientById_NotFound() throws Exception {
        mockMvc.perform(get("/patients/999"))  // Asegúrate que este ID no exista
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("not found")));
    }



    @Test
    public void testCreatePatient() throws Exception {
        String json = """
        {
            
            "name": "Lucia",
            "dateOfBirth": "1993-05-20",
            "admittedBy": {
                "id": 1,
                "name": "Dr. House",
                "department": "Cardiology",
                "status": "ON"
            }
        }
        """;

        mockMvc.perform(post("/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}



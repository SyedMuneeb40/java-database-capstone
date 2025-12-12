package com.smartclinicmanagement.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "prescriptions")
public class Prescription {
    @Id
    private String id;
    private Long appointmentId;
    private Long doctorId;
    private Long patientId;
    private List<Medication> medications;
    private String doctorNotes;
    private int refillCount;
    private Pharmacy pharmacy;
    private LocalDateTime createdAt;

    public static class Medication {
        private String name;
        private String dosage;
        private String duration;
        // Getters & Setters
    }

    public static class Pharmacy {
        private String name;
        private String location;
        // Getters & Setters
    }

    // Getters & Setters
}


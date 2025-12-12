package com.smartclinicmanagement.Service;


import com.smartclinicmanagement.Model.Doctor;
import com.smartclinicmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<String> getAvailability(Long doctorId, LocalDate date) {
        Optional<Doctor> docOpt = doctorRepository.findById(doctorId);
        if(docOpt.isEmpty()) return Collections.emptyList();

        Doctor doctor = docOpt.get();
        // Example: returns static available times, replace with real logic
        return Arrays.asList("08:00","09:00","10:00","11:00");
    }

    public boolean validateLogin(String email, String password) {
        Optional<Doctor> docOpt = doctorRepository.findByEmail(email);
        return docOpt.isPresent() && docOpt.get().getPassword().equals(password);
    }
}
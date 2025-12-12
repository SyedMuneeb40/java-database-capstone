package com.smartclinicmanagement.repository;

import com.smartclinicmanagement.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

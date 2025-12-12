package com.smartclinicmanagement.repository;

import com.smartclinicmanagement.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
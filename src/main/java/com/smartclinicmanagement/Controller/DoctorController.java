package com.smartclinicmanagement.Controller;





import com.smartclinicmanagement.Model.Appointment;
import com.smartclinicmanagement.Model.Doctor;
import com.smartclinicmanagement.repository.AppointmentRepository;
import com.smartclinicmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Doctor Dashboard
    @GetMapping("/doctor/dashboard")
    public String doctorDashboard(Model model) {
        // In real app, get currently logged-in doctor
        // For demo, fetch first doctor
        Doctor doctor = doctorRepository.findById(1L).orElse(null);

        if (doctor != null) {
            // Get appointments for this doctor
            List<Appointment> appointments = appointmentRepository.findByDoctorId(doctor.getId());
            model.addAttribute("appointments", appointments);
            model.addAttribute("doctorName", doctor.getName());
        }

        return "doctor-dashboard";  // Thymeleaf page
    }
}

